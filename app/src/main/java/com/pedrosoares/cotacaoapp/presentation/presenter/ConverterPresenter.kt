package com.pedrosoares.cotacaoapp.presentation.presenter

import android.util.Log
import com.pedrosoares.cotacaoapp.core.base.BasePresenter
import com.pedrosoares.cotacaoapp.model.usecase.CurrencyUseCase
import com.pedrosoares.cotacaoapp.presentation.CurrencyContract

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ConverterPresenter(private val view: CurrencyContract.CurrencyListView) : BasePresenter(), CurrencyContract.ConverterPresenter {

    private val useCase = CurrencyUseCase()

    override fun fetchCurrency() {
        //view.loading()
        val disposable = useCase.currency
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ currencyDomain ->
                    currencyDomain?.let {
                        view.populateCurrency(currencyDomain)
                        //view.success()
                    }
                },
                        { e ->
                             Log.e("ERROR",e.message)
                        }
                )
        compositeDisposable!!.add(disposable)
    }

}
