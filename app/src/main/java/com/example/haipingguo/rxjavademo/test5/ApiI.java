package com.example.haipingguo.rxjavademo.test5;

import android.net.Uri;

import java.util.List;

public interface ApiI {

    AsyncJob<List<Cat>> queryCats(String query);
    AsyncJob<Uri> store(Cat cat);
}


