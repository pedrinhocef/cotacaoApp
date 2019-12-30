package com.pedrosoares.cotacaoapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import com.android.vending.billing.IInAppBillingService
import com.google.android.gms.ads.MobileAds
import com.pedrosoares.cotacaoapp.core.base.BaseActivity
import com.pedrosoares.cotacaoapp.presentation.view.fragment.ExchangeListFragment

class MainActivity : BaseActivity() {

    var mServiceConn: ServiceConnection? = null
    var mService: IInAppBillingService? = null
    var Product_ID = "product_button_click"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this, getString(R.string.id_app))
        mServiceConn = object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName) {
                mService = null
            }

            override fun onServiceConnected(name: ComponentName,
                                            service: IBinder) {
                mService = IInAppBillingService.Stub.asInterface(service)
            }
        }
        val serviceIntent = Intent("com.android.vending.billing.InAppBillingService.BIND")
        serviceIntent.setPackage("com.android.vending")
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE)
        setFragment(R.id.frame_main_activity, ExchangeListFragment(), this)
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    public override fun onDestroy() {
        super.onDestroy()
        mService.let{
            unbindService(mServiceConn)
        }
    }
}