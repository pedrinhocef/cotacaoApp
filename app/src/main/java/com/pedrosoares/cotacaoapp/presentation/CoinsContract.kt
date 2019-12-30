package com.pedrosoares.cotacaoapp.presentation

import com.pedrosoares.cotacaoapp.core.base.BaseContract.Presenter
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain

interface CoinsContract {
    interface CoinsListView {
        fun populateCoins(coinsDomain: CoinsDomain)
        fun success()
        fun loading()
        fun error()
    }

    interface CoinsListPresenter : Presenter {
        fun fetchCoins()
    }

    interface ListenerLayout {
        fun verifyLayout(): Boolean
    }
}