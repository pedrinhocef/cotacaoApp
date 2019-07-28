package com.pedrosoares.cotacaoapp.presentation.view.fragment


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseFragment
import com.pedrosoares.cotacaoapp.model.domain.ARSDomain
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain
import com.pedrosoares.cotacaoapp.model.domain.CurrencyDomain
import com.pedrosoares.cotacaoapp.model.domain.EURDomain
import com.pedrosoares.cotacaoapp.model.domain.GBPDomain
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain
import com.pedrosoares.cotacaoapp.model.domain.USDDomain
import com.pedrosoares.cotacaoapp.presentation.CurrencyContract
import com.pedrosoares.cotacaoapp.presentation.presenter.CurrencyPresenter
import com.pedrosoares.cotacaoapp.presentation.view.adapter.ExchangeRateAdapter

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_error.*
import kotlinx.android.synthetic.main.fragment_exchange_list.*

class ExchangeListFragment : BaseFragment<CurrencyContract.CurrencyListPresenter>(), CurrencyContract.CurrencyListView {


    private var exchangeRateAdapter: ExchangeRateAdapter? = null
    private var coinsDomainList: MutableList<Any>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_exchange_list, container, false)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageRefreshError.setOnClickListener { v -> presenter!!.fetchCurrency() }

        initUi()
    }

    override fun onResume() {
        super.onResume()
        if (isConnected) {
            if (view != null) {
                Snackbar.make(view!!, "Conectado", 1000).show()
                //saveUserPreferences();
            }
        } else {
            if (view != null)
                Snackbar.make(view!!, "Sem Conexão", 1000).show()
        }


        swipeRefresh.setOnRefreshListener {
            swipeRefresh.setColorSchemeResources(android.R.color.holo_green_dark)
            initUi()
            swipeRefresh.isRefreshing = false
        }

    }

    private fun initUi() {

        presenter!!.fetchCurrency()
        coinsDomainList = ArrayList()
        exchangeRateAdapter = ExchangeRateAdapter(context!!, coinsDomainList!!)
        rvListExchange.adapter = exchangeRateAdapter

        val layoutManager = LinearLayoutManager(activity)
        rvListExchange.setHasFixedSize(true)
        rvListExchange.layoutManager = layoutManager


    }

    override fun createPresenter() = CurrencyPresenter(this)

    override fun populateCurrency(currencyDomain: CurrencyDomain) {
        if (context != null) swipeRefresh.background = ContextCompat.getDrawable(context!!, R.drawable.background)
        addCoinsToArray(currencyDomain)
        tvLastUpdate.text = getString(R.string.last_update) + (" " + currencyDomain.btc?.createDate?.let { changeDateFormat(it) })
        exchangeRateAdapter!!.notifyDataSetChanged()
    }

    private fun addCoinsToArray(currencyDomain: CurrencyDomain) {
        currencyDomain.let {
            val ars = it.ars
            val btc = it.btc
            val usd = it.usd
            val ltc = it.ltc
            val eur = it.eur
            val gbp = it.gbp

            defineCardsPosition(ars!!, btc!!, usd!!, ltc!!, eur!!, gbp!!)
        }
    }

    private fun changeDateFormat(date: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val targetFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        var d: Date? = null
        val dateFormatted: String
        try {
            d = simpleDateFormat.parse(date)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        dateFormatted = targetFormat.format(d)
        return dateFormatted.replace("-", "/")
    }

    private fun defineCardsPosition(ars: ARSDomain, btc: BTCDomain, usd: USDDomain, ltc: LTCDomain, eur: EURDomain, gbp: GBPDomain) {
        coinsDomainList!!.add(0, usd)
        coinsDomainList!!.add(1, eur)
        coinsDomainList!!.add(2, gbp)
        coinsDomainList!!.add(3, ars)
        coinsDomainList!!.add(4, btc)
        coinsDomainList!!.add(5, ltc)
    }

    override fun success() {
        tvLastUpdate.visibility = View.VISIBLE
        rvListExchange.visibility = View.VISIBLE
        includeLayoutLoading.visibility = View.GONE
        includeLayoutError.visibility = View.GONE
        //includeToolbarExchange.setVisibility(View.VISIBLE);
    }

    override fun loading() {
        tvLastUpdate.visibility = View.GONE
        includeLayoutLoading.visibility = View.VISIBLE
        includeLayoutError.visibility = View.GONE
        rvListExchange.visibility = View.GONE
    }

    override fun error() {
        tvLastUpdate.text = ""
        if (activity != null) swipeRefresh.setBackgroundColor(activity!!.resources.getColor(R.color.color_white))
        includeLayoutError.visibility = View.VISIBLE
        includeLayoutLoading.visibility = View.GONE
        rvListExchange.visibility = View.GONE
    }




}
