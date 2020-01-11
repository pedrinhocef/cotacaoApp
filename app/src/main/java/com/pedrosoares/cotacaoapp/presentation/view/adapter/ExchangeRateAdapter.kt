package com.pedrosoares.cotacaoapp.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder
import com.pedrosoares.cotacaoapp.model.CurrencyModelContract
import com.pedrosoares.cotacaoapp.model.domain.*
import com.pedrosoares.cotacaoapp.presentation.CurrencyContract
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.*

interface ExchangeRateListener{
    fun onCurrencySelected(bid: String)
}


class ExchangeRateAdapter(private val context: Context,
                          private val currencyDomainList: List<Any>)
                          //private val listener: ExchangeRateListener)
                        : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_exchange_linear, parent, false)

        return when (viewType) {
            //USD_CURRENCY -> DolarViewHolder(view,listener)
            USD_CURRENCY -> DolarViewHolder(view)
            EURO_CURRENCY -> EuroViewHolder(view)
            BITCOIN -> BitCoinViewHolder(view)
            LITECOIN -> LiteCoinViewHolder(view)
            GBP -> LibraViewHolder(view)
            ARS -> PesoArgentineViewHolder(view)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) = (holder as BaseViewHolder<Any>).bind(currencyDomainList[position])

    override fun getItemCount() = currencyDomainList.size


    override fun getItemViewType(position: Int): Int {

        return when (currencyDomainList[position]) {
            is BTCDomain -> BITCOIN
            is EURDomain -> EURO_CURRENCY
            is USDTDomain -> USD_CURRENCY
            is LTCDomain -> LITECOIN
            is GBPDomain -> GBP
            is ARSDomain -> ARS
            else -> position
        }

    }

    companion object {
        private const val USD_CURRENCY = 0
        private const val EURO_CURRENCY = 1
        private const val BITCOIN = 2
        private const val LITECOIN = 3
        private const val GBP = 4
        private const val ARS = 5
    }


}

