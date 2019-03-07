package com.pedrosoares.cotacaoapp.presentation.presenter;

import com.pedrosoares.cotacaoapp.core.base.BasePresenter;
import com.pedrosoares.cotacaoapp.model.usecase.CoinsUseCase;
import com.pedrosoares.cotacaoapp.presentation.CoinsContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CoinsPresenter extends BasePresenter implements CoinsContract.CoinsListPresenter {

    private CoinsContract.CoinsListView view;
    private CoinsUseCase useCase;

    public CoinsPresenter(CoinsContract.CoinsListView view) {
        this.view = view;
        useCase = new CoinsUseCase();
    }

    @Override
    public void fetchCoins() {
        view.loading();
        Disposable disposable = useCase.getCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                            if (it != null) {
                                view.populateCoins(it);
                                view.success();
                            }
                        },
                        error -> view.error());
        compositeDisposable.add(disposable);
    }

}
