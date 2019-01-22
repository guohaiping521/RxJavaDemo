package com.example.haipingguo.rxjavademo.rxdemo.switchThread;


public enum EmptyDisposable implements QueueDisposable<Object> {
    INSTANCE;

    @Override
    public void dispose() {

    }

    @Override
    public boolean isDisposed() {
        return false;
    }
}
