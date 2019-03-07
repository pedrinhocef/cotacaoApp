package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.EURDomain;

import butterknife.Bind;

public class EuroViewHolder extends BaseViewHolder<EURDomain> {

    @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

    @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

    @Bind(R.id.tv_high)
    TextView tvHighPrice;

    @Bind(R.id.tv_low)
    TextView tvLowPrice;

    public EuroViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(EURDomain eurDomain) {
        tvCoinName.setText(eurDomain.getName());
        tvCoinValue.setText(eurDomain.getBid());
        tvLowPrice.setText(eurDomain.getLow());
        tvHighPrice.setText(eurDomain.getHigh());
    }

}
