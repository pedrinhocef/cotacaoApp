package com.pedrosoares.cotacaoapp.core.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {


    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(T type);

    //public void objectHolder(String nameHolder, RecyclerView.ViewHolder holder) { }
}