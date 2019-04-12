package com.pedrosoares.cotacaoapp.core.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected static String NF_NDEC = "#0.000";
    protected static String NF_BR2D = "#0.00";

    protected BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public abstract void bind(T type);

    protected void formatValue(TextView tv, String value, String pattern){
        String a = getValueWithBRL(value, pattern);
        tv.setText(a);
    }

    private static String getValueWithBRL(String value, String pattern) {
        if (value != null) {
            DecimalFormat df = new DecimalFormat(pattern);
            value = df.format(Double.valueOf(value.replace(",", "")));
            return "R$ " + value.trim();
            }
        return "";
    }
}