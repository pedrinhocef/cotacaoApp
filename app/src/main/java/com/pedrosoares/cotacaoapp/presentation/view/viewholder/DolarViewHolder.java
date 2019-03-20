package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.content.Context;
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

    @Bind(R.id.tv_high)
    TextView tvHighPrice;

    @Bind(R.id.tv_low)
    TextView tvLowPrice;

    private Context context;


    public DolarViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void bind(USDDomain usdDomain) {
        tvCoinName.setText(context.getString(R.string.dolar_coin));
        formatValue(tvCoinValue,usdDomain.getBid(),NF_NDEC);
        formatValue(tvLowPrice,usdDomain.getLow(),NF_NDEC);
        formatValue(tvHighPrice,usdDomain.getHigh(),NF_NDEC);
    }
}