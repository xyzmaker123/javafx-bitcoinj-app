package com.xyzmake;

import com.google.common.collect.Lists;
import org.bitcoinj.core.*;
import org.bitcoinj.core.listeners.DownloadProgressTracker;
import org.bitcoinj.params.RegTestParams;
import org.bitcoinj.script.Script;
import org.bitcoinj.store.BlockStoreException;
import org.bitcoinj.store.MemoryBlockStore;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws BlockStoreException, InterruptedException, UnknownHostException, ExecutionException {
        NetworkParameters params = RegTestParams.get();

        List<String> mnemonic = Lists.newArrayList(
                "dune", 
                "pledge", 
                "alpha", 
                "improve", 
                "wrap", 
                "setup", 
                "near", 
                "raise",
                "caution",
                "sea",
                "scrap", 
                "october"
        );
        DeterministicSeed seed = new DeterministicSeed(mnemonic, null, "", 0);
        Wallet wallet = Wallet.fromSeed(params, seed, Script.ScriptType.P2PKH);
        System.out.println("Fresh address: " + wallet.freshReceiveAddress());

        MemoryBlockStore chainStore = new MemoryBlockStore(params);
        BlockChain chain = new BlockChain(params, chainStore);
        PeerGroup peerGroup = new PeerGroup(params, chain);
        peerGroup.addAddress(new PeerAddress(params, InetAddress.getLocalHost(), 8335));

        // Now we need to hook the wallet up to the blockchain and the peers. This registers event listeners that notify our wallet about new transactions.
        chain.addWallet(wallet);
        peerGroup.addWallet(wallet);

        DownloadProgressTracker bListener = new DownloadProgressTracker() {
            @Override
            public void doneDownload() {
                System.out.println("blockchain downloaded");
            }
        };

        // Now we re-download the blockchain. This replays the chain into the wallet. Once this is completed our wallet should know of all its transactions and print the correct balance.
        peerGroup.start();
        peerGroup.startBlockChainDownload(bListener);

        bListener.await();

        // Print a debug message with the details about the wallet. The correct balance should now be displayed.
        System.out.println(wallet.toString());
        
        Set<Transaction> transactions = wallet.getTransactions(true);
        System.out.println("Transactions: " + transactions.size());
        peerGroup.stop();
        
        Address address = wallet.freshReceiveAddress();
        
        // TODO: create Alice instance in bitcoinj
        // TODO: implement on receive listener
        // TODO: send from Bob to Alice
        // TODO: print UTXOs
        // TODO: send to Bob
        
//        DumpedPrivateKey privateKey = DumpedPrivateKey.fromBase58(params, "cVDUgUEahS1swavidSk1zdSHQpCy1Ac9XSQHkaxmZKcTTfEA5vTY");
//        ECKey key = privateKey.getKey();
//        
//        System.out.println("Private key as hex:");
//        System.out.println(key.getPrivateKeyAsHex());
//        
//        System.out.println("Public key as hex:");
//        System.out.println(key.getPublicKeyAsHex());
    }
}
