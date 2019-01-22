package com.example.haipingguo.rxjavademo.rxdemo.switchThread;


import com.example.haipingguo.rxjavademo.rxdemo.Scheduler;

import java.util.concurrent.Callable;


public class RxJavaPlugins {
    public static Scheduler initNewThreadScheduler(Callable<Scheduler> defaultScheduler) {
        return null;
      /*  Function<? super Callable<Scheduler>, ? extends Scheduler> f = onInitNewThreadHandler;
        if (f == null) {
            return callRequireNonNull(defaultScheduler);
        }
        return applyRequireNonNull(f, defaultScheduler);*/
    }
}
