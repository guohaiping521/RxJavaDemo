package com.example.haipingguo.rxjavademo.test5;

import java.util.List;

/*找出所有猫的类*/
public class QuestAllCatAsyncJob extends Observable<List<Cat>> {

    private Api mApi=new Api();
    private String mQuery;

    public void setQuery(String query){
        mQuery=query;
    }

    @Override
    public void subscribe(final Callback<List<Cat>> callback) {
        mApi.queryCats(mQuery).subscribe(new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> result) {
                callback.onResult(result);
            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });
    }
}
