package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.content.Context;
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

    private Context context;


    public EuroViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void bind(EURDomain type) {
        tvCoinName.setText(type.getName());
        formatValue(tvCoinValue,type.getBid(),NF_NDEC);
        formatValue(tvLowPrice,type.getLow(),NF_NDEC);
        formatValue(tvHighPrice,type.getHigh(),NF_NDEC);
    }

}
