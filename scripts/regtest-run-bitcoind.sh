#!/bin/bash

bitcoind \
		-regtest \
		-prune=0 \
		-txindex=1 \
		-peerbloomfilters=1 \
		-server \
		-rpcuser=user \
		-rpcpassword=password \
		-datadir=.localnet/bitcoind \
		-blocknotify='.localnet/bitcoind/blocknotify %s'