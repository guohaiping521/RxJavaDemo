package com.example.haipingguo.rxjavademo.test2;

import android.net.Uri;

import java.util.List;

public interface ApiI {

    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);
        void onError(Exception e);
    }

    void queryCats(String query,CatsQueryCallback catsQueryCallback);
    Uri store(Cat cat);
}


