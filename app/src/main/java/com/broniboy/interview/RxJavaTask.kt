package com.broniboy.interview

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RxJavaTask {

    init {

        fun doSomething(): String = "something"

        Single.just(doSomething())
            .subscribeOn(Schedulers.io())
            .flatMap { Single.just(it) }
            .observeOn(Schedulers.computation())
            .map { it }
            .doOnSubscribe { }
            .observeOn(Schedulers.single())
            .subscribe()
    }
}