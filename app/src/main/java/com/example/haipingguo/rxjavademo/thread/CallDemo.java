package com.example.haipingguo.rxjavademo.thread;

import android.util.Log;

import java.util.concurrent.Callable;

public class CallDemo implements Callable<String>{
    @Override
    public String call() throws Exception {
        String th_name = Thread.currentThread().getName();
        Log.i("ghpppp",th_name + "遭遇大规模敌军突袭...");
        Log.i("ghpppp",th_name + "迅速变换阵型...");
        return "敌军损失惨重，我军大获全胜";
    }
}
