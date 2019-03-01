package com.pedrosoares.cotacaoapp.presentation.fragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.core.base.BaseFragment;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;
import com.pedrosoares.cotacaoapp.model.util.RecyclerItemClickListener;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;
import com.pedrosoares.cotacaoapp.presentation.adapter.CotacaoAdapter;
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CotacaoFragment extends BaseFragment<CoinsPresentationContract.CoinsPresenter> implements CoinsPresentationContract.Fragment {


    @Bind(R.id.rv_list_cambio)
    RecyclerView rvListCambio;

    CotacaoAdapter cotacaoAdapter;

    List<Comparable> data;

    List<CoinsDomain> coinsDomainList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cotacao, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.fetchCoins();
    }

    @Override
    public CoinsPresentationContract.CoinsPresenter createPresenter() {
        return new CoinsPresenter(getContext(), this);
    }

    @Override
    public void populateCoins(CoinsDomain coinsDomain) {
        coinsDomainList.add(coinsDomain);

        if (getContext() != null) {
            //LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);


            cotacaoAdapter = new CotacaoAdapter(getContext(),coinsDomainList);

            cotacaoAdapter.addTo(coinsDomainList);
            rvListCambio.setLayoutManager(new LinearLayoutManager(getContext()));
            rvListCambio.setAdapter(cotacaoAdapter);

            rvListCambio.addItemDecoration(
                    new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }

        listOnClick();
    }

    @Override
    public void loading() {

    }

    @Override
    public void error() {

    }

    private void listOnClick(){

        rvListCambio.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rvListCambio, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }

            @Override
            public void onLongItemClick(View view, int position) {}

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {}
        }));
    }

}
