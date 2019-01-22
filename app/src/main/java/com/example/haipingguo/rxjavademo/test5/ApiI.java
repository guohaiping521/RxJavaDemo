package com.example.haipingguo.rxjavademo.test5;

import android.net.Uri;

import java.util.List;

public interface ApiI {

    Observable<List<Cat>> queryCats(String query);
    Observable<Uri> store(Cat cat);
}


