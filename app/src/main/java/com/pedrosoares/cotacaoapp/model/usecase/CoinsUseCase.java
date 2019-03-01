package com.pedrosoares.cotacaoapp.model.usecase;

import android.content.Context;

import com.pedrosoares.cotacaoapp.data.entity.CoinsResponse;
import com.pedrosoares.cotacaoapp.data.remote.service.Requester;
import com.pedrosoares.cotacaoapp.model.CoinsModelContract;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.mapper.CoinsMapper;

import io.reactivex.Observable;

public class CoinsUseCase implements CoinsModelContract.UseCase {

    private Context context;
    private Requester requester;

    public CoinsUseCase(Context context){
        this.context = context;
        this.requester = new Requester();
    }

    @Override
    public Observable<CoinsDomain> getCoins() {
        Observable<CoinsResponse> observable = requester.getCoins().getAllCoins();
        return observable.map(CoinsMapper::transformEntityToDomain);
    }
}
