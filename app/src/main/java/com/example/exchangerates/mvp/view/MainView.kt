package com.example.exchangerates.mvp.view

import com.arellomobile.mvp.MvpView


interface MainView : MvpView {
    fun onSearchFragmentAdapter()
    fun snackBar(isShow : Boolean)
}