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
import com.pedrosoares.cotacaoapp.presentation.fragment.CotacaoFragment;
import com.pedrosoares.cotacaoapp.presentation.presenter.CoinsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CotacaoActivity extends BaseActivity implements CoinsPresentationContract.Activity {

    @Bind(R.id.content_frame)
    FrameLayout contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotacao);

        ButterKnife.bind(this);

        if (savedInstanceState== null){
            CotacaoFragment fragment = new CotacaoFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_frame,fragment)
                    .commit();
        }
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
