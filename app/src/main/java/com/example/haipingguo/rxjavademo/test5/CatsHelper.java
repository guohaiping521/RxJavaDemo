package com.example.haipingguo.rxjavademo.test5;

import android.net.Uri;
import android.util.Log;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi = new Api();

    public void saveTheCutestCat(String query) {
        ShowCatUriAsyncJob showCatUriAsyncJob=new ShowCatUriAsyncJob();
        showCatUriAsyncJob.setQuery(query).subscribe(new Callback<Uri>() {
            @Override
            public void onResult(Uri result) {
                Log.i("ghppppp","result=="+result);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    public Observable<Uri> saveCutestCat(final String query) {
       return new Observable<Uri>(){
           @Override
           public void subscribe(final Callback<Uri> callback) {
               mApi.queryCats(query).subscribe(new Callback<List<Cat>>() {
                   @Override
                   public void onResult(List<Cat> result) {
                       Cat cat = findCutest(result);
                       mApi.store(cat).subscribe(new Callback<Uri>() {
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
