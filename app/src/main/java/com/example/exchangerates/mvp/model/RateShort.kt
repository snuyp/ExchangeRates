package com.example.exchangerates.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RateShort (
    @SerializedName("Cur_ID")
    @Expose
    var curID: Int?,
    @SerializedName("Date")
    @Expose
    var date: String?,
    @SerializedName("Cur_OfficialRate")
    @Expose
    var curOfficialRate: Float?
)