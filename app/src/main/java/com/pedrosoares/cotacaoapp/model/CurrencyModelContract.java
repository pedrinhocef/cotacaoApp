package com.pedrosoares.cotacaoapp.model;

import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain;

import io.reactivex.Observable;

public interface CurrencyModelContract {

    interface CurrencyUseCase {
        Observable<CurrencyDomain> getCurrency();
    }
}
