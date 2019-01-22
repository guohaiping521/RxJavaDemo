package com.example.haipingguo.rxjavademo.rxdemo.switchThread;

import com.example.haipingguo.rxjavademo.rxdemo.DisposableI;
import com.example.haipingguo.rxjavademo.rxdemo.ObservableI;
import com.example.haipingguo.rxjavademo.rxdemo.ObserverI;
import com.example.haipingguo.rxjavademo.rxdemo.Scheduler;

import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.disposables.Disposable;


public class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;

    public ObservableSubscribeOn(ObservableI<T> source, Scheduler scheduler) {
        super(source);
        this.scheduler = scheduler;
    }

    @Override
    protected void subscribeActual(ObserverI observer) {
        final SubscribeOnObserver<T> parent = new SubscribeOnObserver<T>(observer);
        scheduler.scheduleDirect(new SubscribeTask(parent));
        //    source.subscribe(parent);
    }

    static final class SubscribeOnObserver<T> extends AtomicReference<DisposableI> implements ObserverI<T>, DisposableI {

        final ObserverI<? super T> observerI;
        final AtomicReference<Disposable> s;

        SubscribeOnObserver(ObserverI actual) {
            this.observerI = actual;
            this.s = new AtomicReference<Disposable>();
        }

        @Override
        public void dispose() {

        }

        @Override
        public boolean isDisposed() {
            return false;
        }

        @Override
        public void onSubscribe(DisposableI d) {

        }

        @Override
        public void onNext(T value) {
            if(!isDisposed()){
                observerI.onNext(value);
            }
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

    final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<T> parent;

        SubscribeTask(SubscribeOnObserver<T> parent) {
            this.parent = parent;
        }

        @Override
        public void run() {
            source.subscribe(parent);
        }
    }
}
