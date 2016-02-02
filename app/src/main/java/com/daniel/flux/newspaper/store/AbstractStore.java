package com.daniel.flux.newspaper.store;

import android.content.Context;

import com.daniel.flux.newspaper.database.datasource.NewsDataSource;
import com.daniel.flux.newspaper.dispatcher.Dispatcher;

public abstract class AbstractStore {
    protected final Dispatcher dispatcher;
    protected final Context context;

    protected final NewsDataSource newsDataSource;

    protected AbstractStore(Dispatcher dispatcher, Context context) {
        this.dispatcher = dispatcher;
        this.context = context;
        this.newsDataSource = new NewsDataSource(this.context);
    }

    protected void emitStoreChange(StoreChangeEvent event) {
        this.dispatcher.emitChange(event);
    }

    public interface StoreChangeEvent {
    }
}