package com.xyzmake;

import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.RegTestParams;

public class Main {
    public static void main(String[] args) {
        NetworkParameters params = RegTestParams.get();

        DumpedPrivateKey privateKey = DumpedPrivateKey.fromBase58(params, "cVDUgUEahS1swavidSk1zdSHQpCy1Ac9XSQHkaxmZKcTTfEA5vTY");
        ECKey key = privateKey.getKey();
        
        System.out.println("Private key as hex:");
        System.out.println(key.getPrivateKeyAsHex());
        
        System.out.println("Public key as hex:");
        System.out.println(key.getPublicKeyAsHex());
    }
}
