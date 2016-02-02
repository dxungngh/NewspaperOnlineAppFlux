package com.daniel.flux.newspaper.action.base;

import android.content.Context;

import com.daniel.flux.newspaper.dispatcher.Dispatcher;
import com.daniel.flux.newspaper.network.NewsApiAdapter;

public class ActionCreator {
    private static final String TAG = ActionCreator.class.getSimpleName();

    protected Context context;

    protected Dispatcher dispatcher;

    protected NewsApiAdapter newsApiAdapter;

    public ActionCreator(Context context, Dispatcher dispatcher) {
        this.context = context;
        this.dispatcher = dispatcher;

        this.newsApiAdapter = new NewsApiAdapter(context);
    }

    protected void dispatch(Action action) {
        this.dispatcher.dispatch(action);
    }
}