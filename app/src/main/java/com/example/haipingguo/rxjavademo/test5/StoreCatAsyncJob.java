package com.example.haipingguo.rxjavademo.test5;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*找出所有猫的类*/
public class StoreCatAsyncJob extends AsyncJob<Uri>{

    private Api mApi=new Api();
    private List<Cat> mCatList=new ArrayList<>();

    public void setCatList(List<Cat> catList) {
        if(!mCatList.isEmpty()){
            mCatList.clear();
        }
        mCatList.addAll(catList);
    }

    @Override
    public void start(final Callback<Uri> callback) {
        Cat cat = findCutest(mCatList);
        mApi.store(cat).start(new Callback<Uri>() {
            @Override
            public void onResult(Uri result) {
                callback.onResult(result);
            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
