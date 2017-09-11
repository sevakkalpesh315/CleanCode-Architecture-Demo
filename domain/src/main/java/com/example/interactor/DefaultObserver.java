package com.example.interactor;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by kalpesh on 05/09/2017.
 */

public class DefaultObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
