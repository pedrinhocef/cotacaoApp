package com.pedrosoares.cotacaoapp.presentation.view.viewholder

import android.view.View
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder
import com.pedrosoares.cotacaoapp.model.domain.EURDomain
import kotlinx.android.synthetic.main.layout_item_exchange_linear.view.*

class EuroViewHolder(itemView: View) : BaseViewHolder<EURDomain>(itemView) {


    override fun bind(type: EURDomain) {
        itemView.tvCoinName.text = type.name
        type.bid?.let { formatValue(itemView.tvCoinValue, it) }
        type.low?.let { formatValue(itemView.tvLowPrice, it) }
        type.high?.let { formatValue(itemView.tvHighPrice, it) }
    }

}
