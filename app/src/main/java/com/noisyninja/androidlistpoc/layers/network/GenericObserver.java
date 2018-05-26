package com.noisyninja.androidlistpoc.layers.network;


import com.noisyninja.androidlistpoc.layers.Utils;

import io.reactivex.observers.DisposableObserver;

/**
 * Generic observer class
 * Created by sudiptadutta on 27/04/18.
 */

public class GenericObserver<T> extends DisposableObserver<T> {

    private static final String NULL_RESPONSE = "Data not found!";

    private ICallback mICallback;

    public GenericObserver(ICallback iCallback) {
        mICallback = iCallback;
    }

    public void onSuccess(T t) {

        Utils.logI(GenericObserver.class, "onSuccess");
        if (t == null) {
            mICallback.onError(new Throwable(NULL_RESPONSE));
        } else {
            mICallback.onSuccess(t);
        }
    }

    @Override
    public void onNext(T t) {
        Utils.logI(GenericObserver.class, "OnNext");
        onSuccess(t);
        dispose();
    }

    @Override
    public void onError(Throwable e) {
        Utils.logI(GenericObserver.class, "onError");
        mICallback.onError(e);
    }

    @Override
    public void onComplete() {
        Utils.logI(GenericObserver.class, "onComplete");

    }
}