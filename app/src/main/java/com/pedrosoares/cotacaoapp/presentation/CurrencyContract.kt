package com.pedrosoares.cotacaoapp.presentation

import com.pedrosoares.cotacaoapp.core.base.BaseContract
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain

interface CurrencyContract {

    interface CurrencyListView {
        fun populateCurrency(currencyDomain: CurrencyDomain)
        fun success()
        fun loading()
        fun error()
    }

    interface CurrencyListPresenter : BaseContract.Presenter {
        fun fetchCurrency()
    }

}
