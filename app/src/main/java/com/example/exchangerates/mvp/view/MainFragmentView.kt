package com.example.exchangerates.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.exchangerates.mvp.model.Rates

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainFragmentView : MvpView{
    fun showRates(rates : Rates)
    fun error(message : String)
}