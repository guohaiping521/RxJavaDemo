package com.example.haipingguo.rxjavademo.thread;

import android.util.Log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void test(){
        CallDemo callDemo = new CallDemo();
        FutureTask<String> futureTask = new FutureTask<String>(callDemo);
        new Thread(futureTask,"敌方").start();
        try {
            String fu = futureTask.get();
            Log.i("ghpppp","test==="+fu);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
