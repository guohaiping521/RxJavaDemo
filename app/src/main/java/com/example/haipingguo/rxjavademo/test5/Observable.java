package com.example.haipingguo.rxjavademo.test5;

public abstract class Observable<T> {
    public abstract void subscribe(Callback<T> callback);
}
