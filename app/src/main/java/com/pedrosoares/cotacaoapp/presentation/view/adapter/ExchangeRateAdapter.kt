package com.pedrosoares.cotacaoapp.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder
import com.pedrosoares.cotacaoapp.model.domain.*
import com.pedrosoares.cotacaoapp.presentation.CoinsContract.ListenerLayout
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.*

class ExchangeRateAdapter(private val context: Context, private val coinsDomainList: MutableList<Any>, private val listenerLayout: ListenerLayout) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val view = if (listenerLayout.verifyLayout()) {
            LayoutInflater.from(context).inflate(R.layout.layout_item_exchange_grid, parent, false)
        } else {
            LayoutInflater.from(context).inflate(R.layout.layout_item_exchange_linear, parent, false)
        }
        return when (viewType) {
            USD_COIN -> {
                DolarViewHolder(view)
            }
            EURO_COIN -> {
                EuroViewHolder(view)
            }
            BITCOIN -> {
                BitCoinViewHolder(view)
            }
            LITECOIN -> {
                LiteCoinViewHolder(view)
            }
            GBP -> {
                LibraViewHolder(view)
            }
            ARS -> {
                PesoArgentineViewHolder(view)
            }
            XRP -> {
                RippleViewHolder(view)
            }
            ETH -> {
                EthereumViewHolder(view)
            }
            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as BaseViewHolder<Any>).bind(coinsDomainList[position])
    }

    override fun getItemCount(): Int {
        return coinsDomainList.size
    }

    override fun getItemViewType(position: Int): Int {
        when (coinsDomainList[position]) {
            is BTCDomain -> {
                return BITCOIN
            }
            is EURDomain -> {
                return EURO_COIN
            }
            is USDTDomain -> {
                return USD_COIN
            }
            is LTCDomain -> {
                return LITECOIN
            }
            is GBPDomain -> {
                return GBP
            }
            is ARSDomain -> {
                return ARS
            }
            is XRPDomain -> {
                return XRP
            }
            is ETHDomain -> {
                return ETH
            }
            else -> return position
        }
    }

    companion object {
        private const val USD_COIN = 0
        private const val EURO_COIN = 1
        private const val BITCOIN = 2
        private const val LITECOIN = 3
        private const val GBP = 4
        private const val ARS = 5
        private const val XRP = 6
        private const val ETH = 7
    }

}