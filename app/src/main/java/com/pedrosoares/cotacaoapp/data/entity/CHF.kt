package com.pedrosoares.cotacaoapp.data.entity

import com.google.gson.annotations.SerializedName

class CHF {
    @SerializedName("varBid")
    var varBid: String? = null
    @SerializedName("high")
    var high: String? = null
    @SerializedName("pctChange")
    var pctChange: String? = null
    @SerializedName("code")
    var code: String? = null
    @SerializedName("low")
    var low: String? = null
    @SerializedName("codein")
    var codein: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("ask")
    var ask: String? = null
    @SerializedName("bid")
    var bid: String? = null
    @SerializedName("create_date")
    var createDate: String? = null
    @SerializedName("timestamp")
    var timestamp: String? = null

}