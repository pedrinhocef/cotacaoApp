package com.pedrosoares.cotacaoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.pedrosoares.cotacaoapp.MainActivity;
import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseFragment;
import com.pedrosoares.cotacaoapp.data.preferences.ManagerPreferences;
import com.pedrosoares.cotacaoapp.model.domain.ARSDomain;
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.domain.EURDomain;
import com.pedrosoares.cotacaoapp.model.domain.GBPDomain;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.USDDomain;
import com.pedrosoares.cotacaoapp.presentation.CoinsContract;
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter;
import com.pedrosoares.cotacaoapp.presentation.view.adapter.ExchangeRateAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExchangeListFragment extends BaseFragment<CoinsContract.CoinsListPresenter> implements CoinsContract.CoinsListView {

    //region BINDS
//    @Bind(R.id.rv_list_exchange)
//    RecyclerView rvListExchange;

//    @Bind(R.id.fragment_error)
    View includeLayoutError;

//    @Bind(R.id.iv_recycler_layout_grid)
//    ImageView imageViewOne;
//
//    @Bind(R.id.iv_recycler_layout_linear)
//    ImageView imageViewTwo;

//    @Bind(R.id.fragment_loading)
    View includeLayoutLoading;

//    @Bind(R.id.tv_last_update)
//    TextView lastUpdate;

//    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    ImageView imageRefreshError;

    //endregion

    private ExchangeRateAdapter exchangeRateAdapter;
    private List<Object> coinsDomainList;

    TextView lastUpdate;
    RecyclerView rvListExchange;
    AdView adView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exchange_list, container, false);

        swipeRefresh = view.findViewById(R.id.swipe_refresh);
        lastUpdate = view.findViewById(R.id.tv_last_update);
        includeLayoutError = view.findViewById(R.id.fragment_error);
        includeLayoutLoading = view.findViewById(R.id.fragment_loading);
        rvListExchange = view.findViewById(R.id.rv_list_exchange);
        imageRefreshError = view.findViewById(R.id.image_refresh);

        adView = view.findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, getActivity());

        imageRefreshError.setOnClickListener(v -> presenter.fetchCoins());

        initUi();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isConnected()) {
            if (getView() != null) {
                Snackbar.make(getView(), "Conectado", 1000).show();
                //saveUserPreferences();
            }
        } else {
            if (getView() != null)
                Snackbar.make(getView(), "Sem Conexão", 1000).show();
        }


        swipeRefresh.setOnRefreshListener(() ->  {
            swipeRefresh.setColorSchemeResources(android.R.color.holo_green_dark);
            initUi();
            swipeRefresh.setRefreshing(false);
        });

    }

    private void initUi(){

        presenter.fetchCoins();
        coinsDomainList = new ArrayList<>();
        exchangeRateAdapter = new ExchangeRateAdapter(getActivity(), coinsDomainList);
        rvListExchange.setAdapter(exchangeRateAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvListExchange.setHasFixedSize(true);
        rvListExchange.setLayoutManager(layoutManager);


    }

    @Override
    public CoinsContract.CoinsListPresenter createPresenter() {
        return new CoinsPresenter(this);
    }

    @Override
    public void populateCoins(CoinsDomain coinsDomain) {
        if (getContext() != null) swipeRefresh.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.background));
        addCoinsToArray(coinsDomain);
        lastUpdate.setText(getString(R.string.last_update).concat(" "+ changeDateFormat(coinsDomain.getBTC().getCreateDate())));
        exchangeRateAdapter.notifyDataSetChanged();
    }

    private void addCoinsToArray(@NonNull CoinsDomain coinsDomain) {
        ARSDomain ars = coinsDomain.getARS();
        BTCDomain btc = coinsDomain.getBTC();
        USDDomain usd = coinsDomain.getUSD();
        LTCDomain ltc = coinsDomain.getLTC();
        EURDomain eur = coinsDomain.getEUR();
        GBPDomain gbp = coinsDomain.getGBP();

        defineCardsPosition(ars, btc, usd, ltc, eur, gbp);
    }

    private String changeDateFormat(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date d = null;
        String dateFormatted;
        try{
            d = simpleDateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateFormatted = targetFormat.format(d);
        return dateFormatted.replace("-","/");
    }

    private void defineCardsPosition(@NonNull ARSDomain ars,@NonNull BTCDomain btc,@NonNull USDDomain usd,@NonNull LTCDomain ltc,@NonNull EURDomain eur,@NonNull GBPDomain gbp) {
        coinsDomainList.add(0,usd);
        coinsDomainList.add(1,eur);
        coinsDomainList.add(2,gbp);
        coinsDomainList.add(3,ars);
        coinsDomainList.add(4,btc);
        coinsDomainList.add(5,ltc);
    }

    @Override
    public void success() {
        lastUpdate.setVisibility(View.VISIBLE);
        rvListExchange.setVisibility(View.VISIBLE);
        includeLayoutLoading.setVisibility(View.GONE);
        includeLayoutError.setVisibility(View.GONE);
        //includeToolbarExchange.setVisibility(View.VISIBLE);
    }

    @Override
    public void loading() {
        lastUpdate.setVisibility(View.GONE);
        includeLayoutLoading.setVisibility(View.VISIBLE);
        includeLayoutError.setVisibility(View.GONE);
        rvListExchange.setVisibility(View.GONE);
        //includeToolbarExchange.setVisibility(View.VISIBLE);
    }

    @Override
    public void error() {
        lastUpdate.setText("");
        if (getActivity() != null) swipeRefresh.setBackgroundColor(getActivity().getResources().getColor(R.color.color_white));
        includeLayoutError.setVisibility(View.VISIBLE);
        includeLayoutLoading.setVisibility(View.GONE);
        rvListExchange.setVisibility(View.GONE);
        //includeToolbarExchange.setVisibility(View.GONE);
    }


//    @OnClick(R.id.image_refresh)
//    void onClickReload(){ presenter.fetchCoins(); }


}
