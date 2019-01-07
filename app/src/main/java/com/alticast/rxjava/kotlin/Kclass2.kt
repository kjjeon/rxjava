package com.alticast.rxjava.kotlin

import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import java.util.concurrent.TimeUnit

class Kclass2 {
    fun createObservableForInterval() =
         Observable.interval(1_000, TimeUnit.MILLISECONDS)
            .zipWith(
                Observable.interval(500, TimeUnit.MILLISECONDS)
            ) { aLong, aLong2 -> println("a = $aLong b = $aLong2")
                aLong * aLong2 }
}