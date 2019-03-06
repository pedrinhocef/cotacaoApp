package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;

import butterknife.Bind;

public class LiteCoinViewHolder extends BaseViewHolder<LTCDomain> {

    @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

    @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

    public LiteCoinViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(LTCDomain ltcDomain) {
        tvCoinName.setText(ltcDomain.getName());
        tvCoinValue.setText(ltcDomain.getBid());
    }
}



