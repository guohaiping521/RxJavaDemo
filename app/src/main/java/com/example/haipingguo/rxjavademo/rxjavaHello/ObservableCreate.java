package com.example.haipingguo.rxjavademo.rxjavaHello;

public class ObservableCreate extends Observable{

    private ObservableOnSubscribeI mOnSubscribeI;

    public ObservableCreate(ObservableOnSubscribeI onSubscribeI) {
        mOnSubscribeI=onSubscribeI;
    }

    @Override
    protected void subscribeAtul(ObserverI observerI) {
        ObservableEmitterA observableEmitterA=new ObservableEmitterA(observerI);
        mOnSubscribeI.subscribe(observableEmitterA);
    }

    public class ObservableEmitterA implements ObservableEmitter{
        ObserverI mObserverI;
        public ObservableEmitterA(ObserverI observerI){
            mObserverI=observerI;
        }
        @Override
        public void onNext(String s) {
            mObserverI.onNext(s);
        }

        @Override
        public void onComplete() {

        }
    }

}
