package com.pedrosoares.cotacaoapp.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyDomain (
        var aud: AUDDomain? = null,
        var btc: BTCDomain? = null,
        var chf: CHFDomain? = null,
        var ars: ARSDomain? = null,
        var jpy: JPYDomain? = null,
        var eur: EURDomain? = null,
        var gbp: GBPDomain? = null,
        var usd: USDDomain? = null,
        var cad: CADDomain? = null,
        var usdt: USDTDomain? = null,
        var ltc: LTCDomain? = null

) : Parcelable