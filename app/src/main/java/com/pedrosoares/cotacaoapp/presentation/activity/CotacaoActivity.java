package com.pedrosoares.cotacaoapp.presentation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.model.util.RecyclerItemClickListener;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;
import com.pedrosoares.cotacaoapp.presentation.adapter.CotacaoAdapter;
import com.pedrosoares.cotacaoapp.presentation.adapter.CotacaoListener;
import com.pedrosoares.cotacaoapp.presentation.fragment.AlertCambioFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CotacaoActivity extends BaseActivity implements CoinsPresentationContract.Activity {


    @Bind(R.id.content_frame)
    FrameLayout contentFragment;

    @Bind(R.id.rv_list_cambio)
    RecyclerView rvListCambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotacao);

        ButterKnife.bind(this);



        setupRecycler();

        listOnClick();


    }
    AlertCambioFragment fragment;

    CotacaoAdapter cotacaoAdapter;


    private void  setupRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvListCambio.setLayoutManager(layoutManager);

        cotacaoAdapter = new CotacaoAdapter(getApplicationContext());

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        rvListCambio.setAdapter(cotacaoAdapter);
        // Configurando um dividr entre linhas, para uma melhor visualização.
        rvListCambio.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }


    private void listOnClick(){

       rvListCambio.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), rvListCambio, new RecyclerItemClickListener.OnItemClickListener() {
           @Override
           public void onItemClick(View view, int position) {
           }

           @Override
           public void onLongItemClick(View view, int position) {}

           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {}
       }));
    }

    @Override
    public void populateCoins() {

    }

    @Override
    public void loading() {

    }

    @Override
    public void error() {

    }
}
