package com.pedrosoares.cotacaoapp.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder
import com.pedrosoares.cotacaoapp.model.domain.*
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.*


class ExchangeRateAdapter(private val context: Context,private var currencyDomainList: MutableList<Any>) : RecyclerView.Adapter<BaseViewHolder<*>>() {


    companion object {
        private const val USD_CURRENCY = 0
        private const val EURO_CURRENCY = 1
        private const val BITCOIN = 2
        private const val LITECOIN = 3
        private const val GBP = 4
        private const val ARS = 5
        private const val ETH = 6
        private const val XRP = 7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_exchange_linear, parent, false)

        return when (viewType) {
            USD_CURRENCY -> DolarViewHolder(view)
            EURO_CURRENCY -> EuroViewHolder(view)
            BITCOIN -> BitCoinViewHolder(view)
            LITECOIN -> LiteCoinViewHolder(view)
            GBP -> LibraViewHolder(view)
            ARS -> PesoArgentineViewHolder(view)
            ETH -> EthereumViewHolder(view)
            XRP -> RippleViewHolder(view)
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
            is ETHDomain -> ETH
            is XRPDomain -> XRP
            else -> position
        }

    }

    fun clear(datas : MutableList<Any>) {
        currencyDomainList = ArrayList()
        currencyDomainList.clear()
        currencyDomainList.addAll(datas)
        notifyDataSetChanged()
    }




}

