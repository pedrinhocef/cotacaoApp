package com.pedrosoares.cotacaoapp.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.domain.EURDomain;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.USDDomain;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;
import com.pedrosoares.cotacaoapp.presentation.view.adapter.CotacaoAdapter;
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CotacaoListFragment extends Fragment implements CoinsPresentationContract.CoinsListView {

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

    private CotacaoAdapter cotacaoAdapter;
    private List<Object> coinsDomainList;
    private int month;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cotacao_list, container, false);
        ButterKnife.bind(this, view);
        initUi();
        return view;
    }

    private void initUi(){
        createPresenter().fetchCoins();
        coinsDomainList = new ArrayList<>();
        cotacaoAdapter = new CotacaoAdapter(getActivity(), coinsDomainList);
        rvListCotacao.setAdapter(cotacaoAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvListCotacao.setHasFixedSize(true);
        rvListCotacao.setLayoutManager(layoutManager);
    }

    @Override
    public CoinsPresentationContract.CoinsListPresenter createPresenter() {
        return new CoinsPresenter(this);
    }

    @Override
    public void populateCoins(CoinsDomain coinsDomain) {
        addCoinsToArray(coinsDomain);
        cotacaoAdapter.notifyDataSetChanged();
    }

    private void addCoinsToArray(CoinsDomain coinsDomain) {
        BTCDomain btc = coinsDomain.getBTC();
        USDDomain usd = coinsDomain.getUSD();
        LTCDomain ltc = coinsDomain.getLTC();
        EURDomain eur = coinsDomain.getEUR();

        coinsDomainList.add(0,btc);
        coinsDomainList.add(1,usd);
        coinsDomainList.add(2,ltc);
        coinsDomainList.add(3,eur);
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
        createPresenter().fetchCoins();
    }
}
