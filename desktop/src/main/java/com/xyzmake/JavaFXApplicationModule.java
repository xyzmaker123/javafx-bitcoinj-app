package com.xyzmake;

import com.google.inject.AbstractModule;
import com.xyzmake.transactions.TransactionsModule;

public class JavaFXApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new TransactionsModule());
    }
}
