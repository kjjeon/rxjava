package com.alticast.rxjava.util

object Util {

    fun getThreadName(): String {
        var threadName = Thread.currentThread().name
        if (threadName.length > 30) {
            threadName = threadName.substring(0, 30) + "..."
        }
        return threadName
    }
}