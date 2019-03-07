package com.pedrosoares.cotacaoapp.presentation;

import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

import io.reactivex.Observable;

public interface CoinsPresentationContract {

    interface CoinsListView {
        CoinsPresentationContract.CoinsListPresenter createPresenter();
        void populateCoins(CoinsDomain coinsDomain);
        void success();
        void loading();
        void error();
    }

    interface CoinsListPresenter {
        void fetchCoins();
    }

    interface UseCase{
        Observable<CoinsDomain> getCoins();
    }
}
