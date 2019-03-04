package com.pedrosoares.cotacaoapp.presentation.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseFragment;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter;

public class AlertCambioFragment extends BaseFragment<CoinsPresentationContract.CoinsPresenter> implements CoinsPresentationContract.Fragment {


    public AlertCambioFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert_cambio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.fetchCoins();
    }

    @Override
    public CoinsPresentationContract.CoinsPresenter createPresenter() {
        return new CoinsPresenter(getContext(), this);
    }

    @Override
    public void populateCoins(CoinsDomain coinsDomain) {

    }

    @Override
    public void loading() {

    }

    @Override
    public void error() {

    }


}
