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

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.core.base.BaseFragment;
import com.pedrosoares.cotacaoapp.model.util.RecyclerItemClickListener;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;
import com.pedrosoares.cotacaoapp.presentation.adapter.CotacaoAdapter;
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter;

import butterknife.Bind;

public class CotacaoFragment extends BaseFragment<CoinsPresentationContract.CoinsPresenter> implements CoinsPresentationContract.Fragment {


    @Bind(R.id.rv_list_cambio)
    RecyclerView rvListCambio;

    CotacaoAdapter cotacaoAdapter;


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
    public void populateCoins() {
          setupRecycler();
          listOnClick();
    }

    @Override
    public void loading() {

    }

    @Override
    public void error() {

    }

    private void  setupRecycler(){

        if (getContext() != null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());


            cotacaoAdapter = new CotacaoAdapter(getContext());

            // Adiciona o adapter que irá anexar os objetos à lista.
            // Está sendo criado com lista vazia, pois será preenchida posteriormente.
            rvListCambio.setAdapter(cotacaoAdapter);
            rvListCambio.setLayoutManager(layoutManager);
            // Configurando um dividr entre linhas, para uma melhor visualização.
            rvListCambio.addItemDecoration(
                    new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }
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
