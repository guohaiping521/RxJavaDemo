package com.example.haipingguo.rxjavademo.test2;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi=new Api();

    public interface CutestCatCallback {
        void onCutestCatSaved(Uri uri);
        void onQueryFailed(Exception e);
    }

    /**
     * 加上回调
     * @param query
     * @param cutestCatCallback
     */
    public void saveTheCutestCat(String query, final CutestCatCallback cutestCatCallback) {
        mApi.queryCats(query, new ApiI.CatsQueryCallback() {//---回调
            @Override
            public void onCatListReceived(List<Cat> cats) {//进行处理数据
                Cat cutest = findCutest(cats);
                Uri uri = mApi.store(cutest);
                cutestCatCallback.onCutestCatSaved(uri);
            }

            @Override
            public void onError(Exception e) {
                cutestCatCallback.onQueryFailed(e);
            }
        });

    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }

}
