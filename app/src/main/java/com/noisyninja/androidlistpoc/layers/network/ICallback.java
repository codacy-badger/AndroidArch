package com.noisyninja.androidlistpoc.layers.network;

/**
 * generic callback for network calls
 * Created by sudiptadutta on 27/04/18.
 */

public interface ICallback<T> {
    void onSuccess(T result);

    void onError(Throwable t);
}

