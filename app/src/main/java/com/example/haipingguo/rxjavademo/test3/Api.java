package com.example.haipingguo.rxjavademo.test3;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class Api implements ApiI {

    @Override
    public void queryCats(String query, CatsQueryCallback catsQueryCallback) {
        List<Cat> catList=new ArrayList<>();
        catList.add(new Cat(0));
        catList.add(new Cat(1));
        catList.add(new Cat(2));
        catsQueryCallback.onCatListReceived(catList);
    }

    @Override
    public void store(Cat cat, StoreCallback storeCallback) {
         storeCallback.onCatStored(Uri.parse("被保存的url"));
    }

}
