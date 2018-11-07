package com.example.haipingguo.rxjavademo.test1;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class Api implements ApiI{
    @Override
    public List<Cat> queryCats(String query) {
        List<Cat> catList=new ArrayList<>();
        catList.add(new Cat(0));
        catList.add(new Cat(1));
        catList.add(new Cat(2));
        return catList;
    }

    @Override
    public Uri store(Cat cat) {
        return Uri.parse("要保存的uri");
    }
}
