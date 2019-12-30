package com.pedrosoares.cotacaoapp.model.usecase

import com.pedrosoares.cotacaoapp.data.entity.CoinsResponse
import com.pedrosoares.cotacaoapp.data.remote.service.Api
import com.pedrosoares.cotacaoapp.data.remote.service.Requester
import com.pedrosoares.cotacaoapp.model.CoinsModelContract
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain
import com.pedrosoares.cotacaoapp.model.mapper.CoinsMapper
import io.reactivex.Observable



class CoinsUseCase : CoinsModelContract.CoinsUseCase {


    override fun getCoins(): Observable<CoinsDomain> {
        val observable : Observable<CoinsResponse> = Requester.service.create(Api::class.java).allCoins
        return observable.map { CoinsMapper.transformEntityToDomain(it) }
    }
}