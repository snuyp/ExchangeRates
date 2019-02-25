package com.example.exchangerates.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Rates(
    @SerializedName("Cur_ID")
    @Expose
    var curID: Int,
    @SerializedName("Date")
    @Expose
    var date: String,
    @SerializedName("Cur_Abbreviation")
    @Expose
    var curAbbreviation: String,
    @SerializedName("Cur_Scale")
    @Expose
    var curScale: Int,
    @SerializedName("Cur_Name")
    @Expose
    var curName: String,
    @SerializedName("Cur_OfficialRate")
    @Expose
    var curOfficialRate: Float
    )