package com.example.haipingguo.rxjavademo.test5;

public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}
