package com.example.haipingguo.rxjavademo.test6;

public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}
