package com.pedrosoares.cotacaoapp.presentation;

import com.pedrosoares.cotacaoapp.core.base.BaseContract;

public interface CoinsPresentationContract  {

    interface Fragment {

    }

    interface Activity {

    }

    interface CoinsPresenter extends BaseContract.Presenter {
        void fetchCoins();
    }
}
