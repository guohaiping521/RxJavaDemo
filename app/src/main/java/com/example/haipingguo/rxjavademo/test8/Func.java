package com.example.haipingguo.rxjavademo.test8;

//T 参数类型  R 返回类型
public interface Func<T, R> {
    R call(T t);
}
