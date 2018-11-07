package com.example.haipingguo.rxjavademo.test6;

import android.net.Uri;
import android.util.Log;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi = new Api();

    public AsyncJob<Uri> saveCutestCat(final String query) {
       return new AsyncJob<Uri>(){
            @Override
            public void start(final Callback<Uri> callback) {
                mApi.queryCats(query).start(new Callback<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        mApi.findCutest(result).start(new Callback<Cat>() {
                            @Override
                            public void onResult(Cat cat) {
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
