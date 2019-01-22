package com.example.haipingguo.rxjavademo.rxdemo;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public class ObservableCreate<T>  extends Observable<T> {

    final ObservableOnSubscribeI<T> source;

    public ObservableCreate(ObservableOnSubscribeI<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(ObserverI<? super T> observer) {
        CreateEmitter createEmitter=new CreateEmitter(observer);
        // observer.onSubscribe(createEmitter);
        try {
           source.subscribe(createEmitter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  class  CreateEmitter<T> implements ObservableEmitter<T>,DisposableI{
      final ObserverI<? super T> observerI;
      CreateEmitter(ObserverI<? super T> observer) {
          this.observerI = observer;
      }

      @Override
      public void dispose() {

      }

      @Override
      public void setDisposable(@Nullable Disposable d) {

      }

      @Override
      public void setCancellable(@Nullable Cancellable c) {

      }

      @Override
      public boolean isDisposed() {
          return false;
      }

      @NonNull
      @Override
      public io.reactivex.ObservableEmitter<T> serialize() {
          return null;
      }

      @Override
      public void onNext(T value) {
          if(!isDisposed()){
              observerI.onNext(value);
          }
      }

      @Override
      public void onError(Throwable error) {

      }

      @Override
      public void onComplete() {

      }
  }
}
