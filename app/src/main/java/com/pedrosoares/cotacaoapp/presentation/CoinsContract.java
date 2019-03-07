package com.pedrosoares.cotacaoapp.presentation;

import com.pedrosoares.cotacaoapp.core.base.BaseContract;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

public interface CoinsContract {

    interface CoinsListView {
        void populateCoins(CoinsDomain coinsDomain);
        void success();
        void loading();
        void error();
    }

    interface CoinsListPresenter extends BaseContract.Presenter {
        void fetchCoins();
    }
}
