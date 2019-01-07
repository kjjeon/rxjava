package com.alticast.rxjava.java;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Jclass2 {

    public Observable createObservableForInterval() {

//        Observable.interval(1_000,TimeUnit.SECONDS)
//                .zipWith(Observable.interval(500, TimeUnit.MILLISECONDS), new BiFunction<Long, Long, Object>() {
//                    @Override
//                    public Object apply(Long aLong, Long aLong2) throws Exception {
//                        return aLong + aLong2;
//                    }
//                });

        return Observable.interval(1_000,TimeUnit.MILLISECONDS)
                .zipWith(Observable.interval(500, TimeUnit.MILLISECONDS), (aLong, aLong2) -> aLong * aLong2);
    }
}
