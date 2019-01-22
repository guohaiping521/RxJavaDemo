package com.example.haipingguo.rxjavademo.rxdemo;

import io.reactivex.annotations.NonNull;

public interface EmitterI<T> {
    void onNext(@NonNull T value);


    void onError(@NonNull Throwable error);


    void onComplete();
}
