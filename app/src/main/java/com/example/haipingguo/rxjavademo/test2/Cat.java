package com.example.haipingguo.rxjavademo.test2;

import android.support.annotation.NonNull;

public class Cat implements Comparable<Cat> {
    int cuteness;

    public Cat(int cuteness) {
        this.cuteness = cuteness;
    }

    @Override
    public int compareTo(@NonNull Cat cat) {
        return Integer.compare(cuteness, cat.cuteness);
    }
}
