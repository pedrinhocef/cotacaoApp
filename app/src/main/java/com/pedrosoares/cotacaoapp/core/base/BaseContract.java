package com.pedrosoares.cotacaoapp.core.base;

public interface BaseContract {

    interface View <P extends BaseContract.Presenter> {
        P createPresenter();
    }

    interface Presenter{
        void onDetach();
        void onAttach();
    }
}
