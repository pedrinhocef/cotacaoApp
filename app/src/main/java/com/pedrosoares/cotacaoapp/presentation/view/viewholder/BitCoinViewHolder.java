package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.content.Context;
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

    private Context context;


    public BitCoinViewHolder(@NonNull View itemView) {
        super(itemView);
       context = itemView.getContext();
    }

    @Override
    public void bind(BTCDomain btcDomain) {
        tvCoinName.setText(btcDomain.getName());
        formatValue(tvCoinValue, btcDomain.getAsk());
        formatValue(tvLowPrice, btcDomain.getLow());
        formatValue(tvHighPrice, btcDomain.getHigh());

    }
}
