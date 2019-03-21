package com.pedrosoares.cotacaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.pedrosoares.cotacaoapp.core.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }, 2000);



    }
}
