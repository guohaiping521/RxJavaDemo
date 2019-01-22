package com.example.haipingguo.rxjavademo.rxjavaHello;

public abstract class Observable {

    public void subscribe(ObserverI observerI){
        subscribeAtul(observerI);
    }

    protected abstract void subscribeAtul(ObserverI observerI);

    public static Observable create(ObservableOnSubscribeI onSubscribeI) {
        return new ObservableCreate(onSubscribeI);
    }
}
