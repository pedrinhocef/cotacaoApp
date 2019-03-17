package com.pedrosoares.cotacaoapp.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class ManagerPreferences {

    private static String LAYOUT_MANAGER = "LAYOUT_MANAGER";
    private static final String USER = "USER";

    private static SharedPreferences getSharedPreferences(@NonNull Context context) {
        return context.getSharedPreferences(USER, Context.MODE_PRIVATE);
    }

    public static String getLayoutManagerRecycler(Context context,String layoutManager){
        return getSharedPreferences(context).getString(LAYOUT_MANAGER, layoutManager);
    }

    public static void setLinearLayoutManager(Context context, String layoutManager){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(LAYOUT_MANAGER, layoutManager);
        editor.apply();
    }

    public static void setGridLayoutManager(Context context,String layoutManager){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(LAYOUT_MANAGER, layoutManager);
        editor.apply();
    }



}
