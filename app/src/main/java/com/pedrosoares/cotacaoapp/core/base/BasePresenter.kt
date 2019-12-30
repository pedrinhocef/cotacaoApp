package com.pedrosoares.cotacaoapp.core.base

import com.pedrosoares.cotacaoapp.core.base.BaseContract.Presenter
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : Presenter {
    protected var compositeDisposable: CompositeDisposable? = null

    override fun onAttach() {
        compositeDisposable = CompositeDisposable()
    }

    override fun onDetach() {
        compositeDisposable?.let { compositeDisposable!!.clear()   }
    }
}