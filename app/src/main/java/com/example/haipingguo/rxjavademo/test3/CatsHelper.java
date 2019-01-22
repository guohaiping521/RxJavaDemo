package com.example.haipingguo.rxjavademo.test3;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi=new Api();

    public interface CutestCatCallback {
        void onSuccess(Uri uri);
        void onError(Exception e);
    }
    public void saveTheCutestCat(String query, final CutestCatCallback cutestCatCallback) {
        mApi.queryCats(query, new ApiI.CatsQueryCallback() {//获取全部猫咪的回调
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                mApi.store(cutest, new ApiI.StoreCallback() {//保存猫咪成功后的回调
                    @Override
                    public void onCatStored(Uri uri) {
                        cutestCatCallback.onSuccess(uri);
                    }
                    @Override
                    public void onError(Exception e) {
                        cutestCatCallback.onError(e);
                    }
                });
            }
            @Override
            public void onError(Exception e) {
                cutestCatCallback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }

}
