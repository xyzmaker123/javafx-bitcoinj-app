#!/bin/bash

#rm -rf .localnet
#mkdir .localnet
#mkdir .localnet/bob

bitcoind \
		-regtest \
		-prune=0 \
		-txindex=1 \
		-peerbloomfilters=1 \
		-datadir=.localnet/bob \
		-port=8332 \
    -rpcport=8333 \
    -rpcuser=rpc \
    -rpcpassword=rpc \
    -connect=127.0.0.1:8335