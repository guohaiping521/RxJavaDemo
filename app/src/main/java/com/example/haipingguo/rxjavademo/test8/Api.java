package com.example.haipingguo.rxjavademo.test8;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Api implements ApiI {
    @Override
    public Observable<List<Cat>> queryCats(String query) {
        return new Observable<List<Cat>>() {
            @Override
            public void subscribe(Callback<List<Cat>> callback) {
                List<Cat> catList=new ArrayList<>();
                catList.add(new Cat(0));
                catList.add(new Cat(1));
                catList.add(new Cat(2));
                callback.onResult(catList);
            }
        };
    }

    @Override
    public Observable<Cat> findCutest(final List<Cat> catList) {
        return new Observable<Cat>() {
            @Override
            public void subscribe(Callback<Cat> callback) {
                callback.onResult(findCatest(catList));
            }
        };
    }

    @Override
    public Observable<Uri> store(Cat cat) {
        return new Observable<Uri>() {
            @Override
            public void subscribe(Callback<Uri> callback) {
                callback.onResult(Uri.parse("被保存的url"));
            }
        };
    }

    private Cat findCatest(List<Cat> cats) {
        return Collections.max(cats);
    }

}
