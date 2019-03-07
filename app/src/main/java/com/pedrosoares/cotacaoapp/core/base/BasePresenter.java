package com.pedrosoares.cotacaoapp.core.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter implements BaseContract.Presenter {

    protected CompositeDisposable compositeDisposable;

    @Override
    public void onAttach() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDetach() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }
}
