package com.example.haipingguo.rxjavademo.test7;

import android.net.Uri;
import android.util.Log;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class CatsHelper {
    Api mApi = new Api();

    public void abc(final String quary) {
        Observable.create(new ObservableOnSubscribe<List<Cat>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<Cat>> observableEmitter) throws Exception {
                mApi.queryCats(quary).start(new Callback<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        observableEmitter.onNext(result);
                    }

                    @Override
                    public void onError(Exception e) {
                        observableEmitter.onError(e);
                    }
                });
            }
        }).map(new Function<List<Cat>, Cat>() {
            @Override
            public Cat apply(List<Cat> cats) throws Exception {
                return findCutest(cats);
            }
        }).flatMap(new Function<Cat, ObservableSource<Uri>>() {
            @Override
            public ObservableSource<Uri> apply(final Cat cat) throws Exception {
                return Observable.create(new ObservableOnSubscribe<Uri>() {
                    @Override
                    public void subscribe(final ObservableEmitter<Uri> observableEmitter) throws Exception {
                        mApi.store(cat).start(new Callback<Uri>() {
                            @Override
                            public void onResult(Uri result) {
                                observableEmitter.onNext(result);
                            }
                            @Override
                            public void onError(Exception e) {
                                observableEmitter.onError(e);
                            }
                        });
                    }
                });
            }
        }).subscribe(new Observer<Uri>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Uri uri) {
                Log.i("ghpppp","uri===="+uri);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public AsyncJob<Uri> saveCutestCat(final String query) {
       return new AsyncJob<Uri>(){
            @Override
            public void start(final Callback<Uri> callback) {
                mApi.queryCats(query).start(new Callback<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        mApi.findCutest(result).start(new Callback<Cat>() {
                            @Override
                            public void onResult(Cat cat) {
                                mApi.store(cat).start(new Callback<Uri>() {
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
