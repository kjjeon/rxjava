package com.alticast.rxjava.java;

import io.reactivex.subjects.PublishSubject;

public class Jclass3 {

    private PublishSubject<String> publishSubject = PublishSubject.create();

    public void push(String str){
        publishSubject.onNext(str);
    }

    public void finish(){
        publishSubject.onComplete();
    }

    public void scbscribe (){
        publishSubject.subscribe();
    }
}
