package com.pedrosoares.cotacaoapp.core.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView


abstract class BaseViewHolder<T> protected constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {


    abstract fun bind(currency : T)

    protected fun formatValue(tv: TextView, value: String) {
        tv.text = "R$ $value"
    }


}