package com.example.exchangerates.api

import com.example.exchangerates.mvp.model.Currency
import com.example.exchangerates.mvp.model.RateShort
import com.example.exchangerates.mvp.model.Rates
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RateService {

    @GET("Currencies/{id}")
    fun getCurrencies(@Path("id") curId : Int): Observable<List<Currency>>


    //курс белорусского рубля по отношению к иностранным валютам
    @GET("Rates?")
    fun getRates(@Query("Periodicity") curId : Int): Observable<List<Rates>>

    //onDate yyyy-m-d
    @GET("Rates?")
    fun getRatesOnDate(@Query("onDate") date : String,
                       @Query("Periodicity") curId : Int ) : Observable<List<Rates>>



    //Cur_ID – внутренний код
    @GET("Rates/Dynamics/{id}?")
    fun getDynamicsRates(@Path("id") curId :Int,
                         @Query("startDate") startDate : String,
                         @Query("endDate") endDate : String) : Observable<List<RateShort>>



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