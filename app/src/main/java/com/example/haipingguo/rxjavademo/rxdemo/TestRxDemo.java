package com.example.haipingguo.rxjavademo.rxdemo;


import android.util.Log;

import com.example.haipingguo.rxjavademo.rxdemo.switchThread.Schedulers;


public class TestRxDemo {

    public static void requestNetData() {
        Observable.create(new ObservableOnSubscribeI<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onNext("3");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
          .subscribe(new ObserverI<String>() {
            private DisposableI disposable;

            @Override
            public void onSubscribe(DisposableI d) {
                disposable=d;
            }

            @Override
            public void onNext(String s) {
                if("2".equals(s)){
                    Log.i("ghppppp","disposable=="+disposable);
                    disposable.dispose();
                }
                Log.i("ghppppp","s=="+s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ghppppp","onError");
            }

            @Override
            public void onComplete() {
                Log.i("ghppppp","onComplete");
            }
        });
    }

}
