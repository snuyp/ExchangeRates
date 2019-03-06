package com.example.exchangerates

import android.app.Application
import com.example.exchangerates.di.AppComponent
import com.example.exchangerates.di.DaggerAppComponent
import com.example.exchangerates.di.modules.AppModule
import com.example.exchangerates.di.modules.RetrofitModule

class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }
}