package com.pedrosoares.cotacaoapp.presentation.view.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import com.android.vending.billing.IInAppBillingService
import com.google.android.gms.ads.MobileAds
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseActivity
import com.pedrosoares.cotacaoapp.presentation.view.adapter.TabAdapter
import com.pedrosoares.cotacaoapp.presentation.view.fragment.ConverterFragment
import com.pedrosoares.cotacaoapp.presentation.view.fragment.ExchangeListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var adapter: TabAdapter? = null

    lateinit var mServiceConn: ServiceConnection
    private var mService: IInAppBillingService? = null
    private var Product_ID = "product_button_click"

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
    }

    override fun onStart() {
        super.onStart()

        adapter = TabAdapter(supportFragmentManager)
        adapter?.let {
            it.addFragment(ExchangeListFragment(), "COTAÇÃO")
            it.addFragment(ConverterFragment(), "CONVERSOR")
            //it.addFragment(SettingsFragment(), "")
        }

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        //tabLayout.getTabAt(2)?.setIcon(R.drawable.icn_settings)
    }


    override fun onBackPressed() { moveTaskToBack(true) }

    public override fun onDestroy() {
        super.onDestroy()
        mService?.let { unbindService(mServiceConn) }
    }

}
