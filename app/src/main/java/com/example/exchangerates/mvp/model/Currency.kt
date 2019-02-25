package com.example.exchangerates.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Currency (

    @SerializedName("Cur_ID")
    @Expose
    var curID: Int? = null,
    @SerializedName("Cur_ParentID")
    @Expose
    var curParentID: Int? = null,
    @SerializedName("Cur_Code")
    @Expose
    var curCode: String? = null,
    @SerializedName("Cur_Abbreviation")
    @Expose
    var curAbbreviation: String? = null,
    @SerializedName("Cur_Name")
    @Expose
    var curName: String? = null,
    @SerializedName("Cur_Name_Bel")
    @Expose
    var curNameBel: String? = null,
    @SerializedName("Cur_Name_Eng")
    @Expose
    var curNameEng: String? = null,
    @SerializedName("Cur_QuotName")
    @Expose
    var curQuotName: String? = null,
    @SerializedName("Cur_QuotName_Bel")
    @Expose
    var curQuotNameBel: String? = null,
    @SerializedName("Cur_QuotName_Eng")
    @Expose
    var curQuotNameEng: String? = null,
    @SerializedName("Cur_NameMulti")
    @Expose
    var curNameMulti: String? = null,
    @SerializedName("Cur_Name_BelMulti")
    @Expose
    var curNameBelMulti: String? = null,
    @SerializedName("Cur_Name_EngMulti")
    @Expose
    var curNameEngMulti: String? = null,
    @SerializedName("Cur_Scale")
    @Expose
    var curScale: Int? = null,
    @SerializedName("Cur_Periodicity")
    @Expose
    var curPeriodicity: Int? = null,
    @SerializedName("Cur_DateStart")
    @Expose
    var curDateStart: String? = null,
    @SerializedName("Cur_DateEnd")
    @Expose
    var curDateEnd: String? = null

)