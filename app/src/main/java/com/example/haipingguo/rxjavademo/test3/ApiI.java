package com.example.haipingguo.rxjavademo.test3;

import android.net.Uri;

import java.util.List;

public interface ApiI {

    interface CatsQueryCallback {//获取所有猫咪的数据接口
        void onCatListReceived(List<Cat> cats);
        void onError(Exception e);
    }
    interface StoreCallback{//保存最可爱猫咪的接口
        void onCatStored(Uri uri);
        void onError(Exception e);
    }
    void queryCats(String query, CatsQueryCallback catsQueryCallback);
    void store(Cat cat, StoreCallback storeCallback);
}


