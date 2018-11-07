package com.example.haipingguo.rxjavademo.test4;

import android.net.Uri;

import java.util.List;

public interface ApiI {
     interface Callback<T> {
        void onResult(T result);
        void onError(Exception e);
    }

    void queryCats(String query, Callback<List<Cat>> catsQueryCallback);
    void store(Cat cat, Callback<Uri> storeCallback);
}


