package com.pedrosoares.cotacaoapp.core.base

interface BaseContract {

    interface View<P : BaseContract.Presenter> {
        fun createPresenter(): P
    }

    interface Presenter {
        fun onDetach()
        fun onAttach()
    }
}
