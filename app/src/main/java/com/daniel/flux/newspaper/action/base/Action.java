package com.daniel.flux.newspaper.action.base;

/**
 * Created by danielnguyen on 1/11/16.
 */
public interface Action {
    public ActionType getType();

    public DataBundle getData();
}
