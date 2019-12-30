package com.pedrosoares.cotacaoapp.presentation.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.gms.ads.AdRequest
import com.pedrosoares.cotacaoapp.R
import com.pedrosoares.cotacaoapp.core.base.BaseFragment
import com.pedrosoares.cotacaoapp.data.preferences.ManagerPreferences.getLayoutManagerRecycler
import com.pedrosoares.cotacaoapp.data.preferences.ManagerPreferences.setGridLayoutManager
import com.pedrosoares.cotacaoapp.data.preferences.ManagerPreferences.setLinearLayoutManager
import com.pedrosoares.cotacaoapp.model.domain.*
import com.pedrosoares.cotacaoapp.presentation.CoinsContract
import com.pedrosoares.cotacaoapp.presentation.CoinsContract.ListenerLayout
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter
import com.pedrosoares.cotacaoapp.presentation.view.adapter.ExchangeRateAdapter
import kotlinx.android.synthetic.main.fragment_error.*
import kotlinx.android.synthetic.main.fragment_exchange_list.*
import kotlinx.android.synthetic.main.toolbar_exchange.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ExchangeListFragment : BaseFragment<CoinsContract.CoinsListPresenter>(), CoinsContract.CoinsListView {


    private var exchangeRateAdapter: ExchangeRateAdapter? = null
    private lateinit var coinsDomainList: MutableList<Any>

    lateinit var layoutManager: RecyclerView.LayoutManager
    var iconChoosed = 0
    lateinit var layoutChoosen: String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_exchange_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        imageRefreshError.setOnClickListener { v -> presenter!!.fetchCoins() }

        initUi()

        imageViewOne.setOnClickListener { setGridAsLayoutChoosen() }
        imageViewTwo.setOnClickListener { setLinearAsLayoutChoosen() }

    }

    private fun setLinearAsLayoutChoosen() {
        iconChoosed = getDrawableId(imageViewOne)
        imageViewOne.visibility = View.VISIBLE
        imageViewTwo.visibility = View.GONE
        layoutManager = LinearLayoutManager(context)
        layoutChoosen = LINEAR_LAYOUT_MANAGER
        setLinearLayoutManager(context!!, layoutChoosen)
        rvListExchange.layoutManager = layoutManager
        rvListExchange.setHasFixedSize(true)
        rvListExchange.adapter = exchangeRateAdapter
    }

    private fun setGridAsLayoutChoosen() {
        iconChoosed = getDrawableId(imageViewTwo)
        imageViewOne.visibility = View.GONE
        imageViewTwo.visibility = View.VISIBLE
        layoutManager = GridLayoutManager(context, 2)
        layoutChoosen = GRID_LAYOUT_MANAGER
        setGridLayoutManager(context!!, layoutChoosen)
        rvListExchange.layoutManager = layoutManager
        rvListExchange.setHasFixedSize(false)
        rvListExchange.adapter = exchangeRateAdapter
    }

    override fun onResume() {
        super.onResume()
        if (isConnected) {
            if (view != null) {
                Snackbar.make(view!!, "Conectado", 1000).show()
                saveUserPreferences()
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

        presenter!!.fetchCoins()
        coinsDomainList = ArrayList()
        exchangeRateAdapter = ExchangeRateAdapter(context!!, coinsDomainList, listenerLayout())
        rvListExchange.adapter = exchangeRateAdapter

        imageViewOne.tag = R.drawable.icn_grid_manager
        imageViewTwo.tag = R.drawable.icn_linear_manager
        iconChoosed = getDrawableId(imageViewOne)

       context.let{
            layoutChoosen = LINEAR_LAYOUT_MANAGER
            layoutChoosen = getLayoutManagerRecycler(it!!, layoutChoosen)
            saveUserPreferences()
        }

    }

    override fun createPresenter() = CoinsPresenter(this)

    @SuppressLint("SetTextI18n")
    override fun populateCoins(coinsDomain: CoinsDomain) {
        if (context != null) swipeRefresh.background = ContextCompat.getDrawable(context!!, R.drawable.background)
        addCoinsToArray(coinsDomain)
        tvLastUpdate.text = getString(R.string.last_update) + (" " + coinsDomain.btc?.createDate?.let { changeDateFormat(it) })
        exchangeRateAdapter!!.notifyDataSetChanged()
    }

    private fun addCoinsToArray(coinsDomain: CoinsDomain) {
        coinsDomain.let {
            val ars = it.ars
            val btc = it.btc
            val usd = it.usd
            val ltc = it.ltc
            val eur = it.eur
            val gbp = it.gbp
            val xrp = it.xrp
            val eth = it.eth

            defineCardsPosition(ars!!, btc!!, usd!!, ltc!!, eur!!, gbp!!, xrp!!, eth!!)
        }
    }

    private fun changeDateFormat(date: String): String? {
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

    private fun defineCardsPosition(ars: ARSDomain, btc: BTCDomain, usd: USDDomain, ltc: LTCDomain, eur: EURDomain, gbp: GBPDomain, xrp: XRPDomain, eth: ETHDomain) {
        with(coinsDomainList){
            add(0, usd)
            add(1, eur)
            add(2, gbp)
            add(3, ars)
            add(4, btc)
            add(5, ltc)
            add(6, xrp)
            add(7, eth)
        }
    }

    override fun success() {
        tvLastUpdate.visibility = View.VISIBLE
        rvListExchange.visibility = View.VISIBLE
        includeLayoutLoading.visibility = View.GONE
        includeLayoutError.visibility = View.GONE
        includeToolbarExchange.visibility = View.VISIBLE
    }

    override fun loading() {
        tvLastUpdate.visibility = View.GONE
        includeLayoutLoading.visibility = View.VISIBLE
        includeLayoutError.visibility = View.GONE
        rvListExchange.visibility = View.GONE
        includeToolbarExchange.visibility = View.VISIBLE
    }

    override fun error() {
        tvLastUpdate.text = ""
        if (activity != null) swipeRefresh.setBackgroundColor(activity!!.resources.getColor(R.color.color_white))
        includeLayoutError.visibility = View.VISIBLE
        includeLayoutLoading.visibility = View.GONE
        rvListExchange.visibility = View.GONE
        includeToolbarExchange.visibility = View.GONE
    }


    fun listenerLayout(): ListenerLayout {
        return object : ListenerLayout {
            override fun verifyLayout(): Boolean {
                return layoutChoosen == GRID_LAYOUT_MANAGER
            }
        }
    }

    private fun getDrawableId(iv: ImageView) = iv.tag as Int

    private fun saveUserPreferences() {
        if (layoutChoosen == GRID_LAYOUT_MANAGER) {
           setGridAsLayoutChoosen()
        } else {
           setLinearAsLayoutChoosen()
        }
    }

    companion object{
        private const val LINEAR_LAYOUT_MANAGER = "LINEAR"
        private const val GRID_LAYOUT_MANAGER = "GRID"
        private const val LAYOUT_MANAGER = "LAYOUT_MANAGER"
    }

}
