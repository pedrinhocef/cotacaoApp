package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.GBPDomain;

import butterknife.Bind;

public class LibraViewHolder extends BaseViewHolder<GBPDomain> {

    @Bind(R.id.tv_coin_name)
    TextView tvCoinName;

    @Bind(R.id.tv_coin_value)
    TextView tvCoinValue;

    @Bind(R.id.tv_high)
    TextView tvHighPrice;

    @Bind(R.id.tv_low)
    TextView tvLowPrice;

    public LibraViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(GBPDomain type) {
        tvCoinName.setText(type.getName());
        tvCoinValue.setText(type.getBid());
        tvLowPrice.setText(type.getLow());
        tvHighPrice.setText(type.getHigh());
    }
}

