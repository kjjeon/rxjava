package com.alticast.rxjava.kotlin

import io.reactivex.subjects.PublishSubject

class Kclass3 {
    private val publishSubject = PublishSubject.create<String>()

    fun push(str: String) {
        publishSubject.onNext(str)
    }

    fun finish() {
        publishSubject.onComplete()
    }

    fun scbscribe(name: String) {
        publishSubject.subscribe { println("[$name] subject =  $it") }
    }
}