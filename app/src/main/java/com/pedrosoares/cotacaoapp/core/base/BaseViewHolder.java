package com.pedrosoares.cotacaoapp.core.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    protected BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public abstract void bind(T type);

    protected void formatValue(TextView tv, String value){
        String a  = getValueWithBRL(value);
        tv.setText(a);
    }

    private static String getValueWithBRL(String value) {
        if (value != null) {
            DecimalFormat df = new DecimalFormat("#0.000");
            value = df.format(Double.valueOf(value));
            return "R$ " + value.trim();
            }
        return "";
    }
}