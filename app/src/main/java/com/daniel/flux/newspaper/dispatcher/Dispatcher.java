package com.daniel.flux.newspaper.dispatcher;

import com.daniel.flux.newspaper.action.base.Action;
import com.daniel.flux.newspaper.store.AbstractStore;
import com.squareup.otto.Bus;

public class Dispatcher {
    private static final String TAG = Dispatcher.class.getSimpleName();

    private final Bus bus;

    public Dispatcher(Bus bus) {
        this.bus = bus;
    }

    public void register(Object object) {
        this.bus.register(object);
    }

    public void unregister(Object object) {
        this.bus.unregister(object);
    }

    public void emitChange(AbstractStore.StoreChangeEvent event) {
        this.post(event);
    }

    public void dispatch(Action action) {
        this.post(action);
    }

    private void post(final Object event) {
        this.bus.post(event);
    }
}