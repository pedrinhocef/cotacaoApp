package com.pedrosoares.cotacaoapp.model.domain

import android.os.Parcel
import android.os.Parcelable

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
): Parcelable {
    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(aud as Parcelable , flags)
        parcel.writeParcelable(eur as Parcelable , flags)
        parcel.writeParcelable(usd as Parcelable , flags)
        parcel.writeParcelable(ltc as Parcelable , flags)
        parcel.writeParcelable(btc as Parcelable , flags)
        parcel.writeParcelable(gbp as Parcelable , flags)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<CurrencyDomain> {
            override fun createFromParcel(parcel: Parcel) = CurrencyDomain(parcel)
            override fun newArray(size: Int) = arrayOfNulls<CurrencyDomain>(size)
        }
    }
}