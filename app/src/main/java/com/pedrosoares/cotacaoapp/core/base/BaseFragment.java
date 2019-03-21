package com.pedrosoares.cotacaoapp.core.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

public abstract class BaseFragment<P extends BaseContract.Presenter> extends Fragment implements BaseContract.View<P> {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter != null) {
            presenter.onAttach();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.onDetach();
        }
    }

    public static void setFragment(int id, Fragment fragment, @NonNull FragmentActivity fragmentActivity) {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment).commit();
    }

    public static void popFragment(FragmentActivity fragmentActivity, int id, int flag) {
        try {
            if(fragmentActivity!=null && fragmentActivity.getSupportFragmentManager()!=null) {
                fragmentActivity.getSupportFragmentManager().popBackStack(id, flag);
            }
        } catch (Exception e) {
            Log.e(e.getMessage(),e.toString());
        }

    }

    public static void removeFragment(FragmentActivity activity, Fragment fragment) {
        try {
            if (fragment != null) {
                activity.getSupportFragmentManager().popBackStack(fragment.getTag(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        } catch (Exception e) {
            Log.e(e.getMessage(),e.toString());
        }

    }

    public boolean isConnected(){
        boolean connected;

        if (getContext() != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

            connected = connectivityManager.getActiveNetworkInfo() != null
                    && connectivityManager.getActiveNetworkInfo().isConnected();

            return connected;
        }
        return false;
    }

    public String monthName(int monthNumber) {
        monthNumber++;
        switch (monthNumber){
            case 1: return "janeiro";
            case 2: return "fevereiro";
            case 3: return  "março";
            case 4: return "abril";
            case 5: return "maio";
            case 6: return "junho";
            case 7: return "julho";
            case 8: return "agosto";
            case 9: return "setembro";
            case 10: return "outubro";
            case 11: return "novembro";
            case 12: return "dezembro";

            default: return "Mês inválido";
        }
    }

    public String convertTimeStampToDate(String timestamp){
        long timeStampLong = Long.parseLong(timestamp)*1000;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeStampLong);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        return date+" de "+monthName(month)+" de "+year;
    }
}
