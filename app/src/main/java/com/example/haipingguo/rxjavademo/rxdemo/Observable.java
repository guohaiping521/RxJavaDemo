package com.example.haipingguo.rxjavademo.rxdemo;


import com.example.haipingguo.rxjavademo.rxdemo.switchThread.ObservableSubscribeOn;

public abstract class Observable<T> implements ObservableI<T>{
    @Override
    public void subscribe(ObserverI<? super T> observer) {
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(ObserverI<? super T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribeI<T> source) {
        return new ObservableCreate<T>(source);
    }

    public final Observable<T> subscribeOn(Scheduler scheduler) {
        return new ObservableSubscribeOn<T>(this, scheduler);
    }
}
