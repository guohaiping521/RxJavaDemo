package com.example.haipingguo.rxjavademo.test8;


public abstract class Observable<T> {
    public abstract void subscribe(Callback<T> callback);

    public <R> Observable<R> map(final Function<T, R> func) {
        final Observable<T> source = this;//this--->实现所有猫咪的实现类
        return new Observable<R>() {
            @Override
            public void subscribe(final Callback<R> callback) {
                source.subscribe(new Callback<T>() {
                    @Override
                    public void onResult(T result) {
                        R mapped = func.apply(result);
                        callback.onResult(mapped);
                    }
                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }

    public <R> Observable<R> flatMap(final Function<T, Observable<R>> func) {
        final Observable<T> source = this;//this--->找到最可爱猫咪的实现类
        return new Observable<R>() {
            @Override
            public void subscribe(final Callback<R> callback) {
                source.subscribe(new Callback<T>() {
                    @Override
                    public void onResult(T result) {
                        Observable<R> observable = func.apply(result);
                        observable.subscribe(new Callback<R>() {
                            @Override
                            public void onResult(R result) {
                                callback.onResult(result);
                            }

                            @Override
                            public void onError(Exception e) {
                                callback.onError(e);
                            }
                        });
                    }
                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }
}
