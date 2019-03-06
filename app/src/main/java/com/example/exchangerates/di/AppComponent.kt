package com.example.exchangerates.di

import android.content.Context
import com.example.exchangerates.api.RateService
import com.example.exchangerates.di.modules.AppModule
import com.example.exchangerates.di.modules.RetrofitModule
import com.example.exchangerates.mvp.presenter.RatesPresenter
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class, RetrofitModule::class])
@Singleton
interface AppComponent {

    var getContext : Context
    var getService : RateService

    fun inject(presenter : RatesPresenter)
}