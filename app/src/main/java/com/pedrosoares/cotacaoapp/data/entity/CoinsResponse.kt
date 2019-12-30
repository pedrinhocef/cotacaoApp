package com.pedrosoares.cotacaoapp.data.entity

import com.google.gson.annotations.SerializedName

data class CoinsResponse (

        @SerializedName("AUD")
        var aud: AUD? = null,

        @SerializedName("BTC")
        var btc: BTC? = null,

        @SerializedName("CHF")
        var chf: CHF? = null,

        @SerializedName("ARS")
        var ars: ARS? = null,

        @SerializedName("JPY")
        var jpy: JPY? = null,

        @SerializedName("EUR")
        var eur: EUR? = null,

        @SerializedName("GBP")
        var gbp: GBP? = null,

        @SerializedName("USD")
        var usd: USD? = null,

        @SerializedName("CAD")
        var cad: CAD? = null,

        @SerializedName("USDT")
        var usdt: USDT? = null,

        @SerializedName("LTC")
        var ltc: LTC? = null,

        @SerializedName("XRP")
        var xrp: XRP? = null,

        @SerializedName("ETH")
        var eth: ETH? = null
)