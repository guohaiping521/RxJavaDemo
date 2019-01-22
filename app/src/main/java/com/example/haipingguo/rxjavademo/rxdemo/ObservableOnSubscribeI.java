package com.example.haipingguo.rxjavademo.rxdemo;


import io.reactivex.annotations.NonNull;

public interface ObservableOnSubscribeI<T> {
    void subscribe(@NonNull ObservableEmitter<T> e) throws Exception;
}
