package com.pedrosoares.cotacaoapp.presentation.view.viewholder

import android.view.View
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain
import kotlinx.android.synthetic.main.layout_item_exchange_linear.view.*

class LiteCoinViewHolder(itemView: View) : BaseViewHolder<LTCDomain>(itemView) {


    override fun bind(currency: LTCDomain) {
        itemView.tvCoinName.text = currency.name
        currency.bid?.let { formatValue(itemView.tvCoinValue, it) }
        currency.low?.let { formatValue(itemView.tvLowPrice, it) }
        currency.high?.let { formatValue(itemView.tvHighPrice, it) }
    }
}



