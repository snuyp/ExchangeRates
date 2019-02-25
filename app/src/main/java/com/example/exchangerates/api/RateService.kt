package com.example.exchangerates.api

import com.example.exchangerates.mvp.model.Rates
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RateService {
    //курса белорусского рубля по отношению к иностранным валютам
    @GET("Rates?")
    fun getRates(@Query("Periodicity") curId : Int): Observable<MutableList<Rates>>

    //onDate yyyy-m-d
    @GET("Rates?")
    fun getRatesOnDate(@Query("onDate") date : String,
                       @Query("Periodicity") curId : Int )



    companion object{
        internal fun create(): RateService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://www.nbrb.by/API/ExRates/" )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RateService::class.java)
        }
    }

}