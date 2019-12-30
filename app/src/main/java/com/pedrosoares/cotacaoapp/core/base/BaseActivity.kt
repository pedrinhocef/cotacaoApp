package com.pedrosoares.cotacaoapp.core.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    open fun setFragment(id: Int, fragment: Fragment?, fragmentActivity: FragmentActivity) {
        val fragmentManager = fragmentActivity.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(id, fragment!!).commit()
    }
}