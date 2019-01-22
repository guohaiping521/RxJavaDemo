package com.example.haipingguo.rxjavademo.rxdemo.switchThread;

import com.example.haipingguo.rxjavademo.rxdemo.Scheduler;

import java.util.concurrent.Callable;


public class Schedulers {

    static final Scheduler NEW_THREAD;

    static {

        NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());
    }

    public static Scheduler newThread() {
        return NEW_THREAD;
    }

    static final class NewThreadTask implements Callable<Scheduler> {
        @Override
        public Scheduler call() throws Exception {
            return NewThreadHolder.DEFAULT;
        }
    }
    static final class NewThreadHolder {
        static final Scheduler DEFAULT = new NewThreadScheduler();
    }
}
