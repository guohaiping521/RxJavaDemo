package com.example.haipingguo.rxjavademo.test6;

public  interface Callback<T> {
    void onResult(T result);
    void onError(Exception e);
}