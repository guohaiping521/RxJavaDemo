package com.example.haipingguo.rxjavademo.rxjavaHello;

import android.util.Log;

public class TestRxDemo {
    public static void requestNetData() {
        Observable.create(new ObservableOnSubscribeI() {
            @Override
            public void subscribe(ObservableEmitter observableEmitter) {
                observableEmitter.onNext("1");
                observableEmitter.onComplete();
            }
        }).subscribe(new ObserverI() {
            @Override
            public void onNext(String s) {
                Log.i("ghppp","s==="+s);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
