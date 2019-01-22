package com.example.haipingguo.rxjavademo.test4;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi = new Api();

    public void saveTheCutestCat(String query, final ApiI.Callback<Uri> callback) {
        mApi.queryCats(query, new ApiI.Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                mApi.store(cutest, new ApiI.Callback<Uri>() {
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

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }

}
