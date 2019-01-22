package com.example.haipingguo.rxjavademo.rxdemo.switchThread;

import com.example.haipingguo.rxjavademo.rxdemo.ObservableI;

public interface HasUpstreamObservableSource<T> {
    ObservableI<T> source();
}
