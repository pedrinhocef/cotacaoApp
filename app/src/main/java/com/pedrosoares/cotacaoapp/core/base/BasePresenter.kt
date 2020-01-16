package com.pedrosoares.cotacaoapp.core.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : BaseContract.Presenter {

    protected var compositeDisposable: CompositeDisposable? = null

    override fun onAttach() {
        compositeDisposable = CompositeDisposable()
    }

    override fun onDetach() {
        compositeDisposable?.let { compositeDisposable!!.clear()   }
    }
}
