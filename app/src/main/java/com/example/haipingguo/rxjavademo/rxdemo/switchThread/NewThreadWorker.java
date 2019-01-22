package com.example.haipingguo.rxjavademo.rxdemo.switchThread;


import com.example.haipingguo.rxjavademo.rxdemo.DisposableI;
import com.example.haipingguo.rxjavademo.rxdemo.Scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Scheduler.Worker implements DisposableI{
    private final ScheduledExecutorService executor;
    volatile boolean disposed;

    public NewThreadWorker(ThreadFactory threadFactory) {
        executor = SchedulerPoolFactory.create(threadFactory);
    }


    public DisposableI schedule( final Runnable runnable, long delayTime, TimeUnit unit) {
        if (disposed) {
            return EmptyDisposable.INSTANCE;
        }
        return scheduleActual(runnable, delayTime, unit, null);
    }

    public ScheduledRunnable scheduleActual(final Runnable run, long delayTime, TimeUnit unit, DisposableContainer parent) {
        //Runnable decoratedRun = RxJavaPlugins.onSchedule(run);

        ScheduledRunnable sr = new ScheduledRunnable(run, parent);

       /* if (parent != null) {
            if (!parent.add(sr)) {
                return sr;
            }
        }*/

        Future<?> f;
        try {
            if (delayTime <= 0) {
                f = executor.submit((Callable<Object>)sr);
            } else {
                f = executor.schedule((Callable<Object>)sr, delayTime, unit);
            }
            sr.setFuture(f);
        } catch (RejectedExecutionException ex) {
            if (parent != null) {
            //    parent.remove(sr);
            }
           // RxJavaPlugins.onError(ex);
        }
//
        return sr;
    }


    @Override
    public void dispose() {
        if (!disposed) {
            disposed = true;
            executor.shutdownNow();
        }
    }

    @Override
    public boolean isDisposed() {
        return disposed;
    }

    public void shutdown() {
        if (!disposed) {
            disposed = true;
            executor.shutdown();
        }
    }

}
