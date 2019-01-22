package com.example.haipingguo.rxjavademo.rxdemo;

import android.support.annotation.NonNull;
import com.example.haipingguo.rxjavademo.rxdemo.switchThread.NewThreadWorker;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {

    public abstract static class Worker implements DisposableI {
        public abstract DisposableI schedule(@NonNull Runnable run, long delay, @NonNull TimeUnit unit);
    }

    public DisposableI scheduleDirect(@NonNull Runnable run) {
        return scheduleDirect(run, 0L, TimeUnit.NANOSECONDS);
    }

    public DisposableI scheduleDirect(Runnable run, long delay, TimeUnit unit) {
        final Worker worker = createWorker();
       // final Runnable decoratedRun = RxJavaPlugins.onSchedule(run);
        DisposeTask task = new DisposeTask(run, worker);
        worker.schedule(task, delay, unit);
        return task;
    }

    public abstract Worker createWorker();

    static final class DisposeTask implements Runnable, DisposableI {

        final Runnable decoratedRun;
        final Worker worker;

        Thread runner;


        public DisposeTask(Runnable run, Worker w) {
            this.decoratedRun = run;
            this.worker = w;
        }

        @Override
        public void dispose() {
            if (runner == Thread.currentThread() && worker instanceof NewThreadWorker) {
                ((NewThreadWorker)worker).shutdown();
            } else {
                worker.dispose();
            }
        }

        @Override
        public boolean isDisposed() {
            return false;
        }

        @Override
        public void run() {
            runner = Thread.currentThread();
            try {
                decoratedRun.run();
            } finally {
                dispose();
                runner = null;
            }
        }
    }
}
