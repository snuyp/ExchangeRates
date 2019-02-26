package com.example.exchangerates.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.exchangerates.mvp.view.MainView
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

@InjectViewState
class ConnectivityPresenter : MvpPresenter<MainView>() {
    lateinit var internetDisposable: Disposable

    fun internetConnectivity()
    {
        internetDisposable = ReactiveNetwork.observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { isConnected ->
                if (!isConnected) {
                    viewState.snackBar(true)
                } else {
                    viewState.snackBar(false)
                }
            }
    }
    fun safelyDispose() {
        listOf(internetDisposable).filter { it.isDisposed }.map { it.dispose()}
    }
}