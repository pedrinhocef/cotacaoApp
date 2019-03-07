package com.pedrosoares.cotacaoapp.model.usecase;

import com.pedrosoares.cotacaoapp.data.entity.CoinsResponse;
import com.pedrosoares.cotacaoapp.data.remote.service.Api;
import com.pedrosoares.cotacaoapp.data.remote.service.Requester;
import com.pedrosoares.cotacaoapp.model.CoinsModelContract;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.mapper.CoinsMapper;

import io.reactivex.Observable;

public class CoinsUseCase implements CoinsModelContract.CoinsUseCase {
    @Override
    public Observable<CoinsDomain> getCoins() {
        Observable<CoinsResponse> observable = Requester.getService().create(Api.class).getAllCoins();
        return observable.map(CoinsMapper::transformEntityToDomain);
    }
}
