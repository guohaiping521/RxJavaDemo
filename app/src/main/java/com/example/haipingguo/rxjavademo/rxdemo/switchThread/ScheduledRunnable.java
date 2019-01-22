package com.example.haipingguo.rxjavademo.rxdemo.switchThread;

import com.example.haipingguo.rxjavademo.rxdemo.DisposableI;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class ScheduledRunnable extends AtomicReferenceArray<Object>
        implements Runnable, Callable<Object>, DisposableI{

    final Runnable actual;
    static final Object DISPOSED = new Object();
    static final Object DONE = new Object();
    static final int PARENT_INDEX = 0;
    static final int FUTURE_INDEX = 1;
    static final int THREAD_INDEX = 2;

    public void setFuture(Future<?> f) {
        for (;;) {
            Object o = get(FUTURE_INDEX);
            if (o == DONE) {
                return;
            }
            if (o == DISPOSED) {
                f.cancel(get(THREAD_INDEX) != Thread.currentThread());
                return;
            }
            if (compareAndSet(FUTURE_INDEX, o, f)) {
                return;
            }
        }
    }

    public ScheduledRunnable(Runnable actual, DisposableContainer parent) {
        super(3);
        this.actual = actual;
        this.lazySet(0, parent);
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isDisposed() {
        return false;
    }

    @Override
    public void run() {

    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
