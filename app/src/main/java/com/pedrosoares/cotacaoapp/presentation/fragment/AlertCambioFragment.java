package com.pedrosoares.cotacaoapp.presentation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseContract;
import com.pedrosoares.cotacaoapp.core.base.BaseFragment;

public class AlertCambioFragment extends BaseFragment {


    public AlertCambioFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cotacao, container, false);
    }

    @Override
    public BaseContract.Presenter createPresenter() {
        return null;
    }
}
