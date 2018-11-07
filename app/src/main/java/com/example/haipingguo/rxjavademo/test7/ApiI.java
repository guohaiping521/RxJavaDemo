package com.example.haipingguo.rxjavademo.test7;

import android.net.Uri;

import java.util.List;

public interface ApiI {

    AsyncJob<List<Cat>> queryCats(String query);
    AsyncJob<Cat> findCutest(List<Cat> catList);
    AsyncJob<Uri> store(Cat cat);
}


