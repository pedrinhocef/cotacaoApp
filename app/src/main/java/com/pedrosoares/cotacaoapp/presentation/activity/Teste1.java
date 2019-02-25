package com.pedrosoares.cotacaoapp.presentation.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;

public class Teste1 extends BaseActivity {


    @Override
    public void onCreate( Bundle savedInstanceState,  PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_cotacao);

    }
}
