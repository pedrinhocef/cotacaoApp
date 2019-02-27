package com.pedrosoares.cotacaoapp.model;

import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

import io.reactivex.Observable;

public interface CoinsModelContract {

    interface UseCase{
        Observable<CoinsDomain> getCoins();
    }
}
