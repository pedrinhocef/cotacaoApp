package com.pedrosoares.cotacaoapp.presentation;

import com.pedrosoares.cotacaoapp.core.base.BaseContract;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

public interface CoinsPresentationContract  {

    interface Fragment {
        void populateCoins(CoinsDomain coinsDomain);
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
