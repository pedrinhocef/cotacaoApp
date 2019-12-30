package com.pedrosoares.cotacaoapp.core.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.ButterKnife

abstract class BaseViewHolder<T> protected constructor(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    abstract fun bind(type: T)
    protected fun formatValue(tv: TextView, value: String) {
        tv.text = "R$ $value"
    }

    companion object {
        protected var NF_NDEC = "#0.000"
        protected var NF_BR2D = "#0.00"
    }

    init {
        ButterKnife.bind(this, itemView)
    }
}