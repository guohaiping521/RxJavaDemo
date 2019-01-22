package com.example.haipingguo.rxjavademo.test1;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi=new Api();

    /*从本地获取图片后进行处理
    * 通常做法*/
    public Uri saveTheCutestCat(String query){
        List<Cat> cats = mApi.queryCats(query);//查找所有的貓咪
        Cat cutest = findCutest(cats);         //找出最可愛的貓咪
        return mApi.store(cutest);             //返回保存的uri
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }

}
