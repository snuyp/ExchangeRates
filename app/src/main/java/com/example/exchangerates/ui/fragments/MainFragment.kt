package com.example.exchangerates.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.exchangerates.R
import com.example.exchangerates.mvp.model.Rates
import com.example.exchangerates.mvp.presenter.RatesPresenter
import com.example.exchangerates.mvp.view.MainFragmentView
import javax.inject.Inject


class MainFragment : MvpAppCompatFragment(), MainFragmentView {

    @Inject
    @InjectPresenter
    internal lateinit var ratesPresenter : RatesPresenter


    companion object {
        fun newInstance(): MainFragment {
            return  MainFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun showRates(rates: Rates) {
        var rates  = rates.curName
    }
    override fun error(message: String) {
        Log.e("Error",message);
    }

    override fun onDestroy() {
        super.onDestroy()
        ratesPresenter.dispose()
    }
}