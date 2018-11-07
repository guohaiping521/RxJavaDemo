package com.example.haipingguo.rxjavademo.test1;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi=new Api();

    /*从本地获取图片后进行处理
    * 通常做法*/
    public Uri saveTheCutestCat(String query){
        List<Cat> cats = mApi.queryCats(query);
        Cat cutest = findCutest(cats);
        return mApi.store(cutest);
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }

}
