package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.USDDomain;

import butterknife.Bind;

public class DolarViewHolder extends BaseViewHolder<USDDomain> {

    @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

    @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

    public DolarViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(USDDomain usdDomain) {
        tvCoinName.setText(usdDomain.getName());
        tvCoinValue.setText(usdDomain.getBid());
    }
}