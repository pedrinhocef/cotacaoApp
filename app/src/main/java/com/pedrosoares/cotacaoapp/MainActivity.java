package com.pedrosoares.cotacaoapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.ads.MobileAds;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.presentation.view.fragment.ExchangeListFragment;

import static com.pedrosoares.cotacaoapp.core.base.BaseFragment.setFragment;

public class MainActivity extends BaseActivity {

    ServiceConnection mServiceConn;
    IInAppBillingService mService;
    String Product_ID = "product_button_click";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        setFragment(R.id.frame_main_activity, new ExchangeListFragment(), this);

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
