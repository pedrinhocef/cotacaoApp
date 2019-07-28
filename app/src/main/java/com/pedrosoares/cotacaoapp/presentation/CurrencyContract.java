package com.pedrosoares.cotacaoapp.presentation;

import com.pedrosoares.cotacaoapp.core.base.BaseContract;
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain;

public interface CurrencyContract {

    interface CurrencyListView {
        void populateCurrency(CurrencyDomain currencyDomain);
        void success();
        void loading();
        void error();
    }

    interface CurrencyListPresenter extends BaseContract.Presenter {
        void fetchCurrency();
    }

    interface ListenerLayout{
        boolean verifyLayout();
    }
}
