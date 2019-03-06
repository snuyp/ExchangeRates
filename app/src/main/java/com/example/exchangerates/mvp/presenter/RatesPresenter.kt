package com.example.exchangerates.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.exchangerates.App
import com.example.exchangerates.mvp.view.MainFragmentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


@InjectViewState
class RatesPresenter : MvpPresenter<MainFragmentView>() {

    private var service = App.component.getService

    lateinit var disposable: Disposable


    override fun onFirstViewAttach() {
        App.component.inject(this);
        getRates()
        super.onFirstViewAttach()
    }

    private fun getRates() {

        disposable = service.getRates(0)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> viewState.showRates(result[0]) },
                { error -> viewState.error(error.toString()) }
            )

    }

    fun dispose() = disposable.dispose()
}