package com.example.haipingguo.rxjavademo.test8;

import android.net.Uri;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.haipingguo.rxjavademo.test8.Function;
/*
import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;*/

public class CatsHelper {
    Api mApi = new Api();

    public void saveCutestCat(final String query) {
        new Observable<List<Cat>>() {
            @Override
            public void subscribe(Callback<List<Cat>> callback) {
                List<Cat> catList=new ArrayList<>();
                catList.add(new Cat(0));
                catList.add(new Cat(1));
                catList.add(new Cat(2));
                callback.onResult(catList);
            }
        }.subscribe(new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> result) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
        /*mApi.queryCats(query).subscribe(new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> result) {

            }

            @Override
            public void onError(Exception e) {

            }
        });*/
        mApi.queryCats(query).map(new Function<List<Cat>, Cat>() {
            @Override
            public Cat apply(List<Cat> catList) {
                return findCutest(catList);
            }
        }).flatMap(new Function<Cat, com.example.haipingguo.rxjavademo.test8.Observable<Uri>>() {
            @Override
            public com.example.haipingguo.rxjavademo.test8.Observable<Uri> apply(Cat cat) {
                return mApi.store(cat);
            }
        }).subscribe(new Callback<Uri>() {
            @Override
            public void onResult(Uri result) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private void guanfangRxjavaCat(){
       /* Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                List<Cat> catList=new ArrayList<>();
                catList.add(new Cat(0));
                catList.add(new Cat(1));
                catList.add(new Cat(2));
                e.onNext(catList);
            }
        }).map(new Function<List<Cat>, Cat>() {
            @Override
            public Cat apply(List<Cat> cats) {
                return findCutest(cats);
            }
        }).flatMap(new Function<Cat, Uri>() {
            @Override
            public Uri apply(Cat cat) throws Exception {
                return Uri.parse("被保存的url");
            }
        }).subscribe(new Observer<Uri>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Uri o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/
    }
    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
