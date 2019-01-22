package com.example.haipingguo.rxjavademo.rxdemo.switchThread;


import com.example.haipingguo.rxjavademo.rxdemo.Observable;
import com.example.haipingguo.rxjavademo.rxdemo.ObservableI;


public abstract class AbstractObservableWithUpstream<T, U> extends Observable<U>
        implements HasUpstreamObservableSource{
    protected final ObservableI<T> source;

    AbstractObservableWithUpstream(ObservableI<T> source) {
        this.source = source;
    }

    @Override
    public ObservableI source() {
        return source;
    }
}
