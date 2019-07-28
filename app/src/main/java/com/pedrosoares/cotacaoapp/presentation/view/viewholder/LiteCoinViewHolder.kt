package com.pedrosoares.cotacaoapp.presentation.view.viewholder

import android.view.View
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain
import kotlinx.android.synthetic.main.layout_item_exchange_linear.view.*

class LiteCoinViewHolder(itemView: View) : BaseViewHolder<LTCDomain>(itemView) {


    override fun bind(type: LTCDomain) {
        itemView.tvCoinName.text = type.name
        type.bid?.let { formatValue(itemView.tvCoinValue, it) }
        type.low?.let { formatValue(itemView.tvLowPrice, it) }
        type.high?.let { formatValue(itemView.tvHighPrice, it) }
    }
}



