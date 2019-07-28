package com.pedrosoares.cotacaoapp.model.usecase

import com.pedrosoares.cotacaoapp.data.entity.CurrencyResponse
import com.pedrosoares.cotacaoapp.data.remote.service.Api
import com.pedrosoares.cotacaoapp.data.remote.service.Requester
import com.pedrosoares.cotacaoapp.model.CoinsModelContract
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain
import com.pedrosoares.cotacaoapp.model.mapper.CurrencyMapper
import io.reactivex.Observable

class CoinsUseCase : CoinsModelContract.CoinsUseCase {
    override fun getCurrency(): Observable<CurrencyDomain> {
        val observable : Observable<CurrencyResponse> = Requester.service.create(Api::class.java).allCurrency
        return observable.map { CurrencyMapper.transformEntityToDomain(it) }
    }
}

