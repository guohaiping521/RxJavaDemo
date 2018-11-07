package com.example.haipingguo.rxjavademo.test8;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

public class CatsHelper {
    Api mApi = new Api();

    public AsyncJob<Uri> saveCutestCat(final String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = mApi.queryCats(query);
        final AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });
        /*AsyncJob<AsyncJob<Uri>> map = cutestCatAsyncJob.map(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return mApi.store(cat);
            }
        });*/
        //AsyncJob<Uri>
        //AsyncJob<AsyncJob<Uri>>   return map;
        AsyncJob<Uri> uriAsyncJob = cutestCatAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return mApi.store(cat);
            }
        });
        return uriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
