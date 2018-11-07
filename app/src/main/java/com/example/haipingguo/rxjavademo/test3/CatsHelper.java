package com.example.haipingguo.rxjavademo.test3;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi=new Api();

    public interface CutestCatCallback {
        void onCutestCatSaved(Uri uri);
        void onQueryFailed(Exception e);
    }

    /*加上回调*/
    public void saveTheCutestCat(String query, final CutestCatCallback cutestCatCallback) {
        mApi.queryCats(query, new ApiI.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                mApi.store(cutest, new ApiI.StoreCallback() {
                    @Override
                    public void onCatStored(Uri uri) {
                        cutestCatCallback.onCutestCatSaved(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        cutestCatCallback.onQueryFailed(e);
                    }
                });
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
