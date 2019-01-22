package com.example.haipingguo.rxjavademo.rxdemo;

import io.reactivex.annotations.NonNull;

/*观察者*/
public interface ObserverI<T> {

    void onSubscribe(@NonNull DisposableI d);

    void onNext(@NonNull T t);

    void onError(@NonNull Throwable e);

    void onComplete();

}
