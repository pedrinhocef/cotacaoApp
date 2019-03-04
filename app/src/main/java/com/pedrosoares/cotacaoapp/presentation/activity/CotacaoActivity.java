package com.pedrosoares.cotacaoapp.presentation.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseActivity;
import com.pedrosoares.cotacaoapp.presentation.CoinsPresentationContract;
import com.pedrosoares.cotacaoapp.presentation.fragment.CotacaoListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CotacaoActivity extends BaseActivity implements CoinsPresentationContract.Activity {

    @Bind(R.id.content_frame)
    FrameLayout contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotacao);

        ButterKnife.bind(this);

        if (savedInstanceState== null){
            CotacaoListFragment fragment = new CotacaoListFragment();
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
