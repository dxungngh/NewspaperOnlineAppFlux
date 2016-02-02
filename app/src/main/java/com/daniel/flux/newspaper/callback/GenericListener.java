package com.daniel.flux.newspaper.callback;

/**
 * Created by danielnguyen on 1/12/16.
 */
public interface GenericListener<T> {
    public void onSuccess(T result);

    public void onFailed(Throwable error);
}
