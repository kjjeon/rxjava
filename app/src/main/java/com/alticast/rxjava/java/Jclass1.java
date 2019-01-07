package com.alticast.rxjava.java;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class Jclass1 {

    public Observable<String> createObservable() {

        MyObservableOnSubscribe observableOnSubscribe = new MyObservableOnSubscribe();
        Observable observable = Observable.create(observableOnSubscribe);

        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onNext("3");
                emitter.onComplete();
            }
        });

        Observable<String> observable2 = Observable.create(it -> {
            it.onNext("lambda");
            it.onNext("a");
            it.onComplete();}
            );

        return observable;
    }

    class MyObservableOnSubscribe implements ObservableOnSubscribe<String> { //제네릭 T

        @Override
        public void subscribe(ObservableEmitter<String> emitter) throws Exception {
            emitter.onNext("a");
            emitter.onNext("b");
            emitter.onNext("c");
//            throw new Exception();
            emitter.onComplete();
        }
    }
}

