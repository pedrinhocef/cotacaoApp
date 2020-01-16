package com.pedrosoares.cotacaoapp.presentation.view.viewholder

import android.view.View
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder
import com.pedrosoares.cotacaoapp.model.domain.ARSDomain
import kotlinx.android.synthetic.main.layout_item_exchange_linear.view.*

class PesoArgentineViewHolder(itemView: View) : BaseViewHolder<ARSDomain>(itemView) {


    override fun bind(currency: ARSDomain) {
        itemView.tvCoinName.text = currency.name
        currency.bid?.let { formatValue(itemView.tvCoinValue, it) }
        currency.low?.let { formatValue(itemView.tvLowPrice, it) }
        currency.high?.let { formatValue(itemView.tvHighPrice, it) }
    }
}



