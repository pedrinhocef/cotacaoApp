package com.pedrosoares.cotacaoapp.core.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.pedrosoares.cotacaoapp.R;

import java.text.DecimalFormat;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    protected BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public abstract void bind(T type);

    protected void formatValue(Context context,TextView tv, String value){
        DecimalFormat formatoValor = new DecimalFormat("###,###,###,###,##0.00");
        String a  = context.getString(R.string.real_symbol)+formatoValor.format(Float.valueOf(value));
        tv.setText(a);
    }
}