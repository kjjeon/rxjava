package com.alticast.rxjava

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alticast.rxjava.java.Jclass1
import com.alticast.rxjava.kotlin.Kclass1
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Jclass1().createObservable()
            .subscribe {
                Log.d(TAG,"jclass1 $it")
            }.drop()

        Kclass1().createObservable()
            .subscribe {
                Log.d(TAG,"kclass1 $it")
            }.drop()


        val d: Disposable = Kclass1().createObservable()
            .subscribe ({
                Log.d(TAG,"kclass1 $it")
            },
                {

                }
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun Disposable.drop(): Disposable = apply { compositeDisposable.add(this) }

    companion object {
        private const val TAG = "rxjava.MainActivity"
    }
}
