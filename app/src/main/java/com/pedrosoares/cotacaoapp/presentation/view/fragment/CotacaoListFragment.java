package com.pedrosoares.cotacaoapp.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseFragment;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CotacaoListFragment extends BaseFragment<CoinsContract.CoinsListPresenter> implements CoinsContract.CoinsListView {

    //region BINDS
    @Bind(R.id.rv_list_cotacao)
    RecyclerView rvListCotacao;

    //@Bind(R.id.tv_date_hour)
    //TextView tvDateAndHour;

    @Bind(R.id.fragment_error)
    View includeLayoutError;

    @Bind(R.id.fragment_loading)
    View includeLayoutLoading;
    //endregion

    private ExchangeRateAdapter cotacaoAdapter;
    private List<Object> coinsDomainList;
    private int month;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cotacao_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, getActivity());
        initUi();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isConnected()) {
            //success
            if (getView()!= null)
            Snackbar.make(getView(),"Conectado",1000).show();
        } else {
            //semConexão
            if (getView()!=null)
            Snackbar.make(getView(),"Sem Conexão",1000).show();
        }
    }

    private void initUi(){
        presenter.fetchCoins();
        coinsDomainList = new ArrayList<>();
        cotacaoAdapter = new ExchangeRateAdapter(getActivity(), coinsDomainList);
        rvListCotacao.setAdapter(cotacaoAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvListCotacao.setHasFixedSize(true);
        rvListCotacao.setLayoutManager(layoutManager);
    }

    @Override
    public CoinsContract.CoinsListPresenter createPresenter() {
        return new CoinsPresenter(this);
    }

    @Override
    public void populateCoins(CoinsDomain coinsDomain) {
        addCoinsToArray(coinsDomain);
        cotacaoAdapter.notifyDataSetChanged();
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

    private void defineCardsPosition(ARSDomain ars, BTCDomain btc, USDDomain usd, LTCDomain ltc, EURDomain eur, GBPDomain gbp) {
        coinsDomainList.add(0,usd);
        coinsDomainList.add(1,eur);
        coinsDomainList.add(2,gbp);
        coinsDomainList.add(3,ars);
        coinsDomainList.add(4,btc);
        coinsDomainList.add(5,ltc);
    }

    @Override
    public void success() {
        rvListCotacao.setVisibility(View.VISIBLE);
        includeLayoutLoading.setVisibility(View.GONE);
        includeLayoutError.setVisibility(View.GONE);
    }

    @Override
    public void loading() {
        includeLayoutLoading.setVisibility(View.VISIBLE);
        includeLayoutError.setVisibility(View.GONE);
        rvListCotacao.setVisibility(View.GONE);
    }

    @Override
    public void error() {
        includeLayoutError.setVisibility(View.VISIBLE);
        includeLayoutLoading.setVisibility(View.GONE);
        rvListCotacao.setVisibility(View.GONE);
    }

    /*public void getFullDate(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1;
        Date date = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        //tvDateAndHour.setText("Atualizado em "+ day+" de "+monthName(month)+", às "+formattedDate);
    } */

   /* private String monthName(int monthNumber) {
        switch (monthNumber){
            case 1: return "janeiro";
            case 2: return "fevereiro";
            case 3: return  "março";
            case 4: return "abril";
            case 5: return "maio";
            case 6: return "junho";
            case 7: return "julho";
            case 8: return "agosto";
            case 9: return "setembro";
            case 10: return "outubro";
            case 11: return "novembro";
            case 12: return "dezembro";

            default: return "Mês inválido";
        }
    } */

    @OnClick(R.id.image_refresh)
    void onClickReload(){
        presenter.fetchCoins();
    }
}
