package com.pedrosoares.cotacaoapp.data.preferences

import android.content.Context
import android.content.SharedPreferences

object ManagerPreferences {

    private val LAYOUT_MANAGER = "LAYOUT_MANAGER"
    private val USER = "USER"

    private fun getSharedPreferences(context: Context) = context.getSharedPreferences(USER, Context.MODE_PRIVATE)


    fun getLayoutManagerRecycler(context: Context, layoutManager: String) = getSharedPreferences(context).getString(LAYOUT_MANAGER, layoutManager)


    fun setLinearLayoutManager(context: Context, layoutManager: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(LAYOUT_MANAGER, layoutManager)
        editor.apply()
    }

    fun setGridLayoutManager(context: Context, layoutManager: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(LAYOUT_MANAGER, layoutManager)
        editor.apply()
    }


}
