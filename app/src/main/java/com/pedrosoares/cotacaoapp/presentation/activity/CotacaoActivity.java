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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.presentation.adapter.CotacaoAdapter;
import com.pedrosoares.cotacaoapp.presentation.adapter.CotacaoListener;
import com.pedrosoares.cotacaoapp.presentation.fragment.AlertCambioFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CotacaoActivity extends AppCompatActivity {

    @Bind(R.id.rv_list_cambio)
    RecyclerView rvListCambio;

    @Bind(R.id.content_frame)
    FrameLayout contentFragment;

    @Bind(R.id.iv_test)
    ImageView imageView;

    Fragment fragment;
    CotacaoAdapter cotacaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotacao);

        ButterKnife.bind(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Teste",Toast.LENGTH_SHORT).show();

                fragment = new AlertCambioFragment();
                contentFragment.setVisibility(View.VISIBLE);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_frame,fragment);

            }
        });

        setupRecycler();

    }

    private void  setupRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvListCambio.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        cotacaoAdapter = new CotacaoAdapter(getApplicationContext(), new CotacaoListener() {
            @Override
            public void onItemClick() {
                fragment = new AlertCambioFragment();
                contentFragment.setVisibility(View.VISIBLE);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_frame,fragment);
            }
        });
        rvListCambio.setAdapter(cotacaoAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        rvListCambio.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


}
