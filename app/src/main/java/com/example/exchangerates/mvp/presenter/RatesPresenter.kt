package com.example.exchangerates.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.exchangerates.api.RateService
import com.example.exchangerates.mvp.model.Rates
import com.example.exchangerates.mvp.view.MainFragmentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@InjectViewState
class RatesPresenter : MvpPresenter<MainFragmentView>() {

    private val apiService by lazy {
        RateService.create()
    }

    private lateinit var disposable : Disposable


    override fun onFirstViewAttach() {
        getRates()
        super.onFirstViewAttach()
    }
    private fun getRates(){

        disposable = apiService.getRates(0)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {result -> viewState.showRates(result[0])},
                {error -> viewState.error(error.toString())}
            )

    }

    fun dispose() = disposable.dispose()
}