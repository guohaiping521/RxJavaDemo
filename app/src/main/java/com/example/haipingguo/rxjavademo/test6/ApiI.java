package com.example.haipingguo.rxjavademo.test6;

import android.net.Uri;

import java.util.List;

public interface ApiI {

    Observable<List<Cat>> queryCats(String query);
    Observable<Cat> findCutest(List<Cat> catList);
    Observable<Uri> store(Cat cat);
}


