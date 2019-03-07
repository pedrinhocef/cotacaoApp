package com.pedrosoares.cotacaoapp.model.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public abstract class ConfigGeral {

    private static FragmentManager fragmentManager;
    private static FragmentTransaction fragmentTransaction;

    public static void setFragment(int id, Fragment fragment, FragmentActivity fragmentActivity) {
        fragmentManager = fragmentActivity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment).commit();
    }
}
