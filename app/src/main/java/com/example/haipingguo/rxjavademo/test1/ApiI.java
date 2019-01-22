package com.example.haipingguo.rxjavademo.test1;

import android.net.Uri;

import java.util.List;

public interface ApiI {
    /**
     * 获取所有的猫咪
     * @param query
     * @return
     */
    List<Cat> queryCats(String query);

    /**
     * 保存最可爱的猫咪,并返回保存的地址
     * @param cat
     * @return
     */
    Uri store(Cat cat);
}
