package com.example.haipingguo.rxjavademo.test5;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class Api implements ApiI {
    @Override
    public AsyncJob<List<Cat>> queryCats(String query) {
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(Callback<List<Cat>> callback) {
                List<Cat> catList=new ArrayList<>();
                catList.add(new Cat(0));
                catList.add(new Cat(1));
                catList.add(new Cat(2));
                callback.onResult(catList);
            }
        };
    }

    @Override
    public AsyncJob<Uri> store(Cat cat) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(Callback<Uri> callback) {
                callback.onResult(Uri.parse("被保存的url"));
            }
        };
    }

}
