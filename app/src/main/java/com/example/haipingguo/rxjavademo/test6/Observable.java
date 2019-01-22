package com.example.haipingguo.rxjavademo.test6;


public abstract class Observable<T> {
    public abstract void subscribe(Callback<T> callback);
}
