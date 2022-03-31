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