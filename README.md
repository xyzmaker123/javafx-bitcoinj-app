# Project demonstrating basics of JavaFX

## To run cli:
```
  ./gradlew :cli:run
```

## To run desktop:
```
  ./gradlew :desktop:run
```


## Setup regtest bitcoind

Inspired by this [article](https://olivermouse.wordpress.com/2018/01/13/connecting-multiple-bitcoin-core-nodes-regtest/)

Setup and run bitcoind:
```
  ./regtest-clean.sh
  ./regtest-run-bitcoind.sh
```

Create wallet:
```
  bitcoin-cli -regtest -rpcuser=user -rpcpassword=password createwallet "Bob"
```

Generate block:
```
  ./regtest-generate-block.sh
```

Run Bob instance:
```
  ./regtest-run-bitcoind-bob.sh
```

Create bob wallet:
```
bitcoin-cli -regtest -rpcuser=rpc -rpcpassword=rpc -rpcport=8333 getwalletinfo
```
