package com.pedrosoares.cotacaoapp.presentation.view.fragment


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.ads.AdRequest

import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseFragment
import com.pedrosoares.cotacaoapp.model.domain.*
import com.pedrosoares.cotacaoapp.presentation.CurrencyContract
import com.pedrosoares.cotacaoapp.presentation.presenter.CurrencyPresenter
import com.pedrosoares.cotacaoapp.presentation.view.adapter.ExchangeRateAdapter

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

import kotlinx.android.synthetic.main.fragment_error.*
import kotlinx.android.synthetic.main.fragment_exchange_list.*

class ExchangeListFragment : BaseFragment<CurrencyContract.CurrencyListPresenter>(), CurrencyContract.CurrencyListView {

    private val exchangeRateAdapter : ExchangeRateAdapter by lazy {
        ExchangeRateAdapter(context!!, currencyDomainList)
//                , object : ExchangeRateListener {
//            override fun onCurrencySelected(bid: String) {
//                val converterFragment = ConverterFragment()
//                val bundle = Bundle()
//                bundle.putString("usd", bid)
//                converterFragment.arguments = bundle
//                converterFragment.getCurrencyDataSelected(bundle.let { converterFragment.arguments!! })
//            }
//        })

    }

    private var currencyDomainList: MutableList<Any> = ArrayList()

    override fun createPresenter() = CurrencyPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_exchange_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        imageRefreshError.setOnClickListener { presenter!!.fetchCurrency() }
        initUi()
    }

    override fun onResume() {
        super.onResume()

        if (isConnected) {
            view.let{ Snackbar.make(view!!, "Conectado", 1000).show() }

        } else {
            view.let{ Snackbar.make(view!!, "Sem Conexão", 1000).show() }
        }


        swipeRefresh.setOnRefreshListener {
            swipeRefresh.setColorSchemeResources(android.R.color.holo_green_dark)
            initUi()
            swipeRefresh.isRefreshing = false
        }

    }

    private fun initUi() {

        presenter!!.fetchCurrency()

        with(rvListExchange){
            adapter = exchangeRateAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
    }



    override fun populateCurrency(currencyDomain: CurrencyDomain) {
        context?.let { swipeRefresh.background = ContextCompat.getDrawable(context!!, R.drawable.background) }
        addCurrencyToArray(currencyDomain)
        tvLastUpdate.text = "${getString(R.string.last_update)} ${currencyDomain.btc?.createDate?.let {changeDateFormat(it)}}"
        exchangeRateAdapter.notifyDataSetChanged()
    }

    private fun addCurrencyToArray(currencyDomain: CurrencyDomain) {
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
        lateinit var dateFormatted : String
        try {
            d = simpleDateFormat.parse(date)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        dateFormatted = targetFormat.format(d)
        return dateFormatted.replace("-", "/")
    }

    private fun defineCardsPosition(ars: ARSDomain, btc: BTCDomain, usd: USDDomain, ltc: LTCDomain, eur: EURDomain, gbp: GBPDomain) {
        with(currencyDomainList) {
            add(0, usd)
            add(1, eur)
            add(2, gbp)
            add(3, ars)
            add(4, btc)
            add(5, ltc)
        }
    }

    override fun success() {
        tvLastUpdate.visibility = View.VISIBLE
        rvListExchange.visibility = View.VISIBLE
        includeLayoutLoading.visibility = View.GONE
        includeLayoutError.visibility = View.GONE
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
