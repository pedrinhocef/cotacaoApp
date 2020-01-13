package com.pedrosoares.cotacaoapp.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.pedrosoares.cotacaoapp.R

import com.pedrosoares.cotacaoapp.core.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({ startActivity(Intent(applicationContext, MainActivity::class.java)) }, 2000)


    }


}
