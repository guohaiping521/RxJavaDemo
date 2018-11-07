package com.example.haipingguo.rxjavademo.test3;

import android.net.Uri;

import java.util.List;

public interface ApiI {

    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);
        void onError(Exception e);
    }

    interface StoreCallback{
        void onCatStored(Uri uri);
        void onStoreFailed(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);
    void store(Cat cat, StoreCallback storeCallback);
}


