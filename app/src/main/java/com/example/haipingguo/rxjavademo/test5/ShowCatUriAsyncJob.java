package com.example.haipingguo.rxjavademo.test5;

import android.net.Uri;

import java.util.List;

public class ShowCatUriAsyncJob extends AsyncJob<Uri> {

    private String mQuery;

    public ShowCatUriAsyncJob setQuery(String query){
        mQuery=query;
        return this;
    }

    @Override
    public void start(final Callback<Uri> callback) {
        QuestAllCatAsyncJob questAllCatAsyncJob = new QuestAllCatAsyncJob();
        questAllCatAsyncJob.setQuery(mQuery);
        questAllCatAsyncJob.start(new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> result) {
                StoreCatAsyncJob storeCatAsyncJob = new StoreCatAsyncJob();
                storeCatAsyncJob.setCatList(result);
                storeCatAsyncJob.start(new Callback<Uri>() {
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
}
