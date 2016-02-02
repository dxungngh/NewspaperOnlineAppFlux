package com.daniel.flux.newspaper.store;

/**
 * Created by danielnguyen on 1/26/16.
 */
public class NewsStoreChangeEvent implements AbstractStore.StoreChangeEvent {
    private final String error;

    public NewsStoreChangeEvent(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}