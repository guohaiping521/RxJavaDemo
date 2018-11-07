package com.example.haipingguo.rxjavademo.test7;

public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}
