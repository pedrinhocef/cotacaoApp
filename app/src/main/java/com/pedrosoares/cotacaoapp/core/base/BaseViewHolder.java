package com.pedrosoares.cotacaoapp.core.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    RecyclerView.ViewHolder holder;


    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void objectHolder(String nameHolder, RecyclerView.ViewHolder holder) { }
}