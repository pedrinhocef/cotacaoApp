package com.pedrosoares.cotacaoapp.presentation.presenter

import com.pedrosoares.cotacaoapp.core.base.BasePresenter
import com.pedrosoares.cotacaoapp.model.usecase.CoinsUseCase
import com.pedrosoares.cotacaoapp.presentation.CurrencyContract

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CurrencyPresenter(private val view: CurrencyContract.CurrencyListView) : BasePresenter(), CurrencyContract.CurrencyListPresenter {

    private val useCase = CoinsUseCase()

    override fun fetchCurrency() {
        view.loading()
        val disposable = useCase.currency
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ currencyDomain ->
                    currencyDomain?.let {
                        view.populateCurrency(currencyDomain)
                        view.success()
                    }
                },
                        { error -> view.error() })
        compositeDisposable!!.add(disposable)
    }

}
