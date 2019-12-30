package com.pedrosoares.cotacaoapp.data.preferences

import android.content.Context
import android.content.SharedPreferences

object ManagerPreferences {
    private const val LAYOUT_MANAGER = "LAYOUT_MANAGER"
    private const val USER = "USER"
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(USER, Context.MODE_PRIVATE)
    }

    @JvmStatic
    fun getLayoutManagerRecycler(context: Context, layoutManager: String?): String {
        return getSharedPreferences(context).getString(LAYOUT_MANAGER, layoutManager)
    }

    @JvmStatic
    fun setLinearLayoutManager(context: Context, layoutManager: String?) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(LAYOUT_MANAGER, layoutManager)
        editor.apply()
    }

    @JvmStatic
    fun setGridLayoutManager(context: Context, layoutManager: String?) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(LAYOUT_MANAGER, layoutManager)
        editor.apply()
    }
}