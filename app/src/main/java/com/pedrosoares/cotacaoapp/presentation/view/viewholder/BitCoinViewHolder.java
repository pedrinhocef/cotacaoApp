package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain;

import butterknife.Bind;

public class BitCoinViewHolder extends BaseViewHolder<BTCDomain> {

    @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

    @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

    @Bind(R.id.tv_high)
    TextView tvHighPrice;

    @Bind(R.id.tv_low)
    TextView tvLowPrice;


    public BitCoinViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(BTCDomain btcDomain) {
        tvCoinName.setText(btcDomain.getName());
        tvCoinValue.setText(btcDomain.getBid());
        tvHighPrice.setText(btcDomain.getHigh());
        tvLowPrice.setText(btcDomain.getLow());
    }
}
