package com.example.pam_app.login

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers

public class SchedulersFactory {

    fun <T> createMainThreadSchedulerTransformer(): ObservableTransformer<T, T> {
        return SchedulersTransformer()
    }
}

internal class SchedulersTransformer<T> : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.observeOn(AndroidSchedulers.mainThread())
    }
}