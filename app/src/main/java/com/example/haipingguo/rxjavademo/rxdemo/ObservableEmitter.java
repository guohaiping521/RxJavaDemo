package com.example.haipingguo.rxjavademo.rxdemo;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public interface ObservableEmitter <T> extends EmitterI<T> {

    void setDisposable(@Nullable Disposable d);


    void setCancellable(@Nullable Cancellable c);


    boolean isDisposed();

    @NonNull
    io.reactivex.ObservableEmitter<T> serialize();
}
