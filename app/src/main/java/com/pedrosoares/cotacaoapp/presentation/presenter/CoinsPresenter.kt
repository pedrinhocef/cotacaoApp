package com.pedrosoares.cotacaoapp.presentation.presenter

import android.util.Log
import com.pedrosoares.cotacaoapp.core.base.BasePresenter
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain
import com.pedrosoares.cotacaoapp.model.usecase.CoinsUseCase
import com.pedrosoares.cotacaoapp.presentation.CoinsContract.CoinsListPresenter
import com.pedrosoares.cotacaoapp.presentation.CoinsContract.CoinsListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CoinsPresenter(val view: CoinsListView) : BasePresenter(), CoinsListPresenter {

    private val useCase = CoinsUseCase()

    override fun fetchCoins() {
        view.loading()
        val disposable = useCase.coins
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it != null) {
                        view.populateCoins(it)
                        view.success()
                    }
                }
                ) {
                    view.error()
                    Log.e("ERRO NO RX", it.message)
                  }
        compositeDisposable!!.add(disposable)
    }

}