package com.example.haipingguo.rxjavademo.rxdemo;

import io.reactivex.annotations.NonNull;

/*被观察者*/
public interface ObservableI<T> {
    void subscribe(@NonNull ObserverI<? super T> observer);
}
