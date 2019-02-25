package com.pedrosoares.cotacaoapp.model.usecase;

import android.content.Context;

import com.pedrosoares.cotacaoapp.data.remote.service.Requester;
import com.pedrosoares.cotacaoapp.model.CoinsModelContract;
import com.pedrosoares.cotacaoapp.model.mapper.CoinsMapper;

import io.reactivex.Observable;

public class CoinsUseCase implements CoinsModelContract.UseCase {


    private Requester requester;

    public CoinsUseCase(Context context) {
        this.requester = requester;
    }

    @Override
    public Observable<com.pedrosoares.cotacaoapp.model.domain.Coins> getCoins() {
        Observable<Coins> observable = requester.getCoins().getAllCoins();
        return observable.map(CoinsMapper::transformEntityToDomain);
    }
}
