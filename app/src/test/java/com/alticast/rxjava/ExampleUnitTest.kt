package com.alticast.rxjava

import com.alticast.rxjava.kotlin.Kclass1
import com.alticast.rxjava.kotlin.Kclass2
import com.alticast.rxjava.kotlin.Kclass3
import com.alticast.rxjava.util.Util
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    @DisplayName("rxjava class1")
    fun rxJavaTest1() {
        val kclass1 = Kclass1()
        kclass1.createObservable()
            .doOnNext { println("it =  $it") }
            .test()
            .assertResult("1")
            .assertComplete()
    }

    @Test
    @DisplayName("rxjava class2")
    fun rxJavaTest2() {
        val kclass2 = Kclass2()
        kclass2.createObservableForInterval()
            .doOnNext { println("o =  $it") }
            .map { it.toInt() }
            .map { it + 2 }
            .filter { it % 2 == 0 }
            .doOnNext { println("filter =  $it") }
            .take(10)
            .test()
            .awaitDone(10,TimeUnit.SECONDS)
    }

    @Test
    fun rxJavaTest3() {
        val kclass2 = Kclass2()
        kclass2.createObservableForInterval()
            .subscribeOn(Schedulers.computation())
            .doOnNext { println("[${Util.getThreadName()}] item1 =  $it") }
            .observeOn(Schedulers.io())
            .doOnNext { println("[${Util.getThreadName()}] item2 =  $it") }
            .take(10)
            .test()
            .awaitDone(10,TimeUnit.SECONDS)
    }

    @Test
    fun rxJavaTest4() {
        val kclass3 = Kclass3()
        kclass3.scbscribe("first")
        kclass3.push("1")
        kclass3.push("2")
        kclass3.push("3")
        kclass3.scbscribe("second")
        kclass3.push("4")
    }



//    @Test
    @DisplayName("rxjava 비동기 테스트")
    fun rxJavaTest10() {
        Observable.concat(
            Observable.interval(100, TimeUnit.MILLISECONDS).take(3),
            Observable.interval(200, TimeUnit.MILLISECONDS).take(3)
        )
            .scan(0, { acc, _ -> acc + 1 })
//                .doOnNext({println(it)})
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertResult(0,1,2,3,4,5,6)
            .assertNoErrors()
            .assertComplete()
            .assertValueCount(7)

        Observable.concat(
            Observable.interval(100, TimeUnit.MILLISECONDS).take(3),
            Observable.interval(200, TimeUnit.MILLISECONDS).take(3)
        )
            .scan(0, { acc, _ -> acc + 1 })
            .timeout(150, TimeUnit.MILLISECONDS, Observable.just(-1))
//                .doOnNext({println(it)})
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertResult(0,1,2,3,-1)
            .assertNoErrors()
            .assertComplete()
            .assertValueCount(5)
    }

//    @Test
    @DisplayName("rxjava test ")
    fun rxjavaTest() {
        val source = Observable.range(0,10)

        source.buffer(2,1)
            .subscribe { println(it) }
//        source.take(5)
//                .doOnError{ println(it) }
//                .doOnNext{ println(it) }
//                .doOnComplete { println("on Complete") }
//                .test()
    }
}
