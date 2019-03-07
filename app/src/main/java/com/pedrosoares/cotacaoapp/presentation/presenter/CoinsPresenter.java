package com.pedrosoares.cotacaoapp.presentation.presenter;

import com.pedrosoares.cotacaoapp.model.util.DisposableManager;
import com.pedrosoares.cotacaoapp.model.CoinsModelContract;
import com.pedrosoares.cotacaoapp.model.usecase.CoinsUseCase;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CoinsPresenter implements CoinsPresentationContract.CoinsListPresenter {

    private CoinsPresentationContract.CoinsListView view;
    private CoinsModelContract.CoinsUseCase useCase;

    public CoinsPresenter(CoinsPresentationContract.CoinsListView view) {
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
        DisposableManager.add(disposable);
    }

}
