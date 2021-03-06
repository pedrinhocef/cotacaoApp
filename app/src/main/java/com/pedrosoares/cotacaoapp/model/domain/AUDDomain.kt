package com.pedrosoares.cotacaoapp.model.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AUDDomain (
    var varBid: String? = null,
    var high: String? = null,
    var pctChange: String? = null,
    var code: String? = null,
    var low: String? = null,
    var codein: String? = null,
    var name: String? = null,
    var ask: String? = null,
    var bid: String? = null,
    var createDate: String? = null,
    var timestamp: String? = null
): Parcelable
