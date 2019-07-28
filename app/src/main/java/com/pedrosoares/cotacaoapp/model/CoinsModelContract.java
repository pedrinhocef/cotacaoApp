package com.pedrosoares.cotacaoapp.model;

import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain;

import io.reactivex.Observable;

public interface CoinsModelContract {

    interface CoinsUseCase{
        Observable<CurrencyDomain> getCurrency();
    }
}
