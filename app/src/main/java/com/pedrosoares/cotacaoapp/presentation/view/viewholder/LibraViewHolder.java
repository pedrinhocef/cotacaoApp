package com.pedrosoares.cotacaoapp.presentation.view.viewholder;

import android.content.Context;
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

    private Context context;


    public LibraViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    @Override
    public void bind(GBPDomain gbpDomain) {
        tvCoinName.setText(context.getString(R.string.libra_coin));
        formatValue(tvCoinValue,gbpDomain.getBid(),NF_NDEC);
        formatValue(tvLowPrice,gbpDomain.getLow(),NF_NDEC);
        formatValue(tvHighPrice,gbpDomain.getHigh(),NF_NDEC);
    }
}

