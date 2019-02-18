package com.pedrosoares.cotacaoapp.presentation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrosoares.cotacaoapp.R;

public class AlertCambioFragment extends Fragment {


    public AlertCambioFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cotacao, container, false);
    }

}
