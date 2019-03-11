package com.pedrosoares.cotacaoapp.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class ManagerPreferences {

    private static final String LINEAR_LAYOUT_MANAGER = "LINEAR";
    private static final String GRID_LAYOUT_MANAGER = "GRID";
    private static String LAYOUT_MANAGER = "LAYOUT_MANAGER";
    private static final String USER = "USER";

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(USER, Context.MODE_PRIVATE);
    }

    public static String getLayoutManagerRecycler(Context context){
        LAYOUT_MANAGER = LAYOUT_MANAGER != null ? GRID_LAYOUT_MANAGER : LINEAR_LAYOUT_MANAGER;
        return getSharedPreferences(context).getString(LAYOUT_MANAGER, "");
    }

    public static void setLinearLayoutManager(Context context, String layoutManager){
        getSharedPreferences(context).edit().putString(LINEAR_LAYOUT_MANAGER, layoutManager).apply();
    }

    public static void setGridLayoutManager(Context context,String layoutManager){
        getSharedPreferences(context).edit().putString(GRID_LAYOUT_MANAGER, layoutManager).apply();
    }



}
