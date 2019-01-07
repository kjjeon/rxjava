package com.alticast.rxjava.kotlin

import io.reactivex.Observable

class Kclass1 {

    fun createObservable() = Observable.create<String> {
        it.onNext("1")
        it.onComplete()
    }
}