package com.pedrosoares.cotacaoapp.presentation.presenter;

import android.content.Context;

import com.pedrosoares.cotacaoapp.core.base.BasePresenter;
import com.pedrosoares.cotacaoapp.model.usecase.CoinsUseCase;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CoinsPresenter extends BasePresenter implements CoinsPresentationContract.CoinsPresenter {

    private Context context;
    private CoinsPresentationContract.Fragment view;
    private CoinsUseCase useCase;

    public CoinsPresenter(Context context, CoinsPresentationContract.Fragment view) {
        this.context = context;
        this.view = view;
        useCase = new CoinsUseCase(context);
    }

    @Override
    public void fetchCoins() {
        view.loading();
        Disposable disposable = useCase.getCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                            if (it != null) {
                                view.populateCoins();
                            }
                        },
                        error -> view.error());
        compositeDisposable.add(disposable);
    }

}
