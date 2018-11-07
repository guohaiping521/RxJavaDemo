package com.example.haipingguo.rxjavademo.test1;

import android.net.Uri;

import java.util.List;

public interface ApiI {
    List<Cat> queryCats(String query);
    Uri store(Cat cat);
}
