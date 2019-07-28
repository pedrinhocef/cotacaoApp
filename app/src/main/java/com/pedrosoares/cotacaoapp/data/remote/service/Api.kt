package com.pedrosoares.cotacaoapp.data.remote.service

import com.pedrosoares.cotacaoapp.data.entity.CurrencyResponse

import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @get:GET("all")
    val allCurrency: Observable<CurrencyResponse>
}
