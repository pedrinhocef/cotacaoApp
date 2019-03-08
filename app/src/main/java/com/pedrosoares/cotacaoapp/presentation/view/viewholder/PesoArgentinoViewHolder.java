package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.ARSDomain;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;

import butterknife.Bind;

public class PesoArgentinoViewHolder extends BaseViewHolder<ARSDomain> {

    @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

    @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

    @Bind(R.id.tv_high)
    TextView tvHighPrice;

    @Bind(R.id.tv_low)
    TextView tvLowPrice;

    private Context context;

    public PesoArgentinoViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void bind(ARSDomain type) {
        tvCoinName.setText(type.getName());
        formatValue(context,tvCoinValue,type.getBid());
        formatValue(context,tvLowPrice,type.getLow());
        formatValue(context,tvHighPrice,type.getHigh());
    }
}



