package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.XRPDomain;

import butterknife.Bind;

public class RippleViewHolder extends BaseViewHolder<XRPDomain> {

    @Bind(R.id.tv_coin_name)
    TextView tvCoinName;

    @Bind(R.id.tv_coin_value)
    TextView tvCoinValue;

    @Bind(R.id.tv_high)
    TextView tvHighPrice;

    @Bind(R.id.tv_low)
    TextView tvLowPrice;

    private Context context;

    public RippleViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void bind(XRPDomain xrpDomain) {
        tvCoinName.setText(context.getString(R.string.ripple_coin));
        formatValue(tvCoinValue,xrpDomain.getAsk());
        formatValue(tvLowPrice,xrpDomain.getLow());
        formatValue(tvHighPrice,xrpDomain.getHigh());
    }
}