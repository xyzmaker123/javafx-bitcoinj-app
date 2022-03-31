#!/bin/bash

bitcoin-cli \
		-regtest \
		-rpcuser=user \
		-rpcpassword=password \
		getnewaddress \
		| xargs bitcoin-cli \
				-regtest \
				-rpcuser=user \
				-rpcpassword=password \
				generatetoaddress 1