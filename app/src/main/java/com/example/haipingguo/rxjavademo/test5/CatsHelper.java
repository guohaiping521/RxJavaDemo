package com.example.haipingguo.rxjavademo.test5;

import android.net.Uri;
import android.util.Log;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi = new Api();

    public void saveTheCutestCat(String query) {
        ShowCatUriAsyncJob showCatUriAsyncJob=new ShowCatUriAsyncJob();
        showCatUriAsyncJob.setQuery(query).start(new Callback<Uri>() {
            @Override
            public void onResult(Uri result) {
                Log.i("ghppppp","result=="+result);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    public AsyncJob<Uri> saveCutestCat(final String query) {
       return new AsyncJob<Uri>(){
            @Override
            public void start(final Callback<Uri> callback) {
                mApi.queryCats(query).start(new Callback<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        Cat cat = findCutest(result);
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

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }
    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
