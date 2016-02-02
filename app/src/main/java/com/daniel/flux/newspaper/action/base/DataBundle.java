package com.daniel.flux.newspaper.action.base;

import java.util.HashMap;

/**
 * Created by danielnguyen on 1/11/16.
 */
public class DataBundle<T extends DataKey> {
    private HashMap<T, Object> map;

    public DataBundle() {
        this.map = new HashMap<T, Object>();
    }

    public void put(T key, Object data) {
        this.map.put(key, data);
    }

    public Object get(T key) {
        Object object = this.map.get(key);
        if (object == null) {
            return null;
        }

        return object;
    }
}