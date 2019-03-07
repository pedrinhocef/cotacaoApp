package com.pedrosoares.cotacaoapp.core.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{

    public boolean isConected(){
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        conectado = conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isConnected();
        return conectado;
    }

}
