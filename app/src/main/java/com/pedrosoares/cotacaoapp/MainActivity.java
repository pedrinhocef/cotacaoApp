package com.pedrosoares.cotacaoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pedrosoares.cotacaoapp.model.util.ConfigGeral;
import com.pedrosoares.cotacaoapp.presentation.view.fragment.CotacaoListFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConfigGeral.setFragment(R.id.frame_main_activity, new CotacaoListFragment(), this);
    }
}
