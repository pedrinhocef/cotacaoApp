package com.pedrosoares.cotacaoapp.presentation.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class TabAdapter(val fm : FragmentManager) : FragmentStatePagerAdapter(fm){

    private val fragmentList : MutableList<Fragment> = ArrayList()
    private val fragmentTitleList : MutableList<String> = ArrayList()

    override fun getItem(position: Int) = fragmentList[position]
    override fun getCount() = fragmentList.size
    override fun getPageTitle(position: Int) = fragmentTitleList[position]

    fun addFragment(fragment: Fragment , title : String?){
        fragmentList.add(fragment)
        title?.let { fragmentTitleList.add(it) }
    }
}