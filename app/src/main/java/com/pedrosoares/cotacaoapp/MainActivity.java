package com.pedrosoares.cotacaoapp;

import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.presentation.view.fragment.ExchangeListFragment;

import static com.pedrosoares.cotacaoapp.core.base.BaseFragment.setFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.id_app));


        setFragment(R.id.frame_main_activity, new ExchangeListFragment(), this);

    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }

}
