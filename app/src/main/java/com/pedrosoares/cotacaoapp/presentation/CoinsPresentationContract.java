package com.pedrosoares.cotacaoapp.presentation;

import com.pedrosoares.cotacaoapp.core.base.BaseContract;

public interface CoinsPresentationContract  {

    interface Fragment {
        void populateCoins();
        void loading();
        void error();
    }

    interface Activity {
        void populateCoins();
        void loading();
        void error();
    }

    interface CoinsPresenter extends BaseContract.Presenter {
        void fetchCoins();
    }
}
