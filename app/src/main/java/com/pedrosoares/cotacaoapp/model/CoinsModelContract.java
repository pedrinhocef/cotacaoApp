package com.pedrosoares.cotacaoapp.model;

import com.pedrosoares.cotacaoapp.model.domain.Coins;

import io.reactivex.Observable;

public interface CoinsModelContract {

    interface UseCase{
        Observable<Coins> getCoins();
    }
}
