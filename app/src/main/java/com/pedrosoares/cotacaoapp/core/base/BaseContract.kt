package com.pedrosoares.cotacaoapp.core.base

interface BaseContract {
    interface View<P : Presenter?> {
        fun createPresenter(): P
    }

    interface Presenter {
        fun onDetach()
        fun onAttach()
    }
}