package com.pedrosoares.cotacaoapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.ads.MobileAds;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.presentation.view.adapter.TabAdapter;
import com.pedrosoares.cotacaoapp.presentation.view.fragment.DetailFragment;
import com.pedrosoares.cotacaoapp.presentation.view.fragment.ExchangeListFragment;
import com.pedrosoares.cotacaoapp.presentation.view.fragment.SettingsFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar_exchange)
    Toolbar includeToolbarExchange;

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    ServiceConnection mServiceConn;
    IInAppBillingService mService;
    String Product_ID = "product_button_click";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MobileAds.initialize(this, getString(R.string.id_app));

        mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }
            @Override
            public void onServiceConnected(ComponentName name,
                                           IBinder service) {
                mService = IInAppBillingService.Stub.asInterface(service);
            }
        };

        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);



        //setFragment(R.id.frame_main_activity, new ExchangeListFragment(), this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        //includeToolbarExchange.setVisibility(View.VISIBLE);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExchangeListFragment(),"LISTA DE MOEDAS");
        adapter.addFragment(new DetailFragment(),"DETALHES");
        adapter.addFragment(new SettingsFragment(),"CONFIGURAÇÕES");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mService != null) {
            unbindService(mServiceConn);
        }
    }

}
