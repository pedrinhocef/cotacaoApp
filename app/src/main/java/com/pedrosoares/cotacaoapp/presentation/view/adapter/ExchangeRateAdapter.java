package com.pedrosoares.cotacaoapp.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.ARSDomain;
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.EURDomain;
import com.pedrosoares.cotacaoapp.model.domain.GBPDomain;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.USDTDomain;
import com.pedrosoares.cotacaoapp.presentation.CoinsContract;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.BitCoinViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.DolarViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.EuroViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.LibraViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.LiteCoinViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.PesoArgentineViewHolder;

import java.util.List;

public class ExchangeRateAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    private Context context;
    private static final int USD_COIN = 0;
    private static final int EURO_COIN = 1;
    private static final int BITCOIN = 2;
    private static final int LITECOIN = 3;
    private static final int GBP = 4;
    private static final int ARS = 5;
    private List<Object> coinsDomainList;
    private CoinsContract.ListenerLayout listenerLayout;

    public ExchangeRateAdapter(Context context, List<Object> coinsDomainList, CoinsContract.ListenerLayout listenerLayout){
        this.listenerLayout = listenerLayout;
        this.context = context;
        this.coinsDomainList = coinsDomainList;
    }

    @NonNull
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (listenerLayout.verifyLayout()) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_exchange_grid, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_exchange_linear, parent, false);
        }

        switch(viewType){
            case USD_COIN: {
                return new DolarViewHolder(view);
            }
            case EURO_COIN: {
                return new EuroViewHolder(view);
            }
            case BITCOIN: {
                return new BitCoinViewHolder(view);
            }
            case LITECOIN: {
                return new LiteCoinViewHolder(view);
            }
            case GBP: {
                return new LibraViewHolder(view);
            }
            case ARS: {
                return new PesoArgentineViewHolder(view);
            }
            default:{
                throw new IllegalArgumentException("Invalid view type");
            }
        }
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Object coinsDomain = coinsDomainList.get(position);
        holder.bind(coinsDomain);
    }


    @Override
    public int getItemCount() {
        return coinsDomainList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object element = coinsDomainList.get(position);

        if (element instanceof BTCDomain) {
            return BITCOIN;
        } else if (element instanceof EURDomain) {
            return EURO_COIN;
        } else if (element instanceof USDTDomain) {
            return USD_COIN;
        } else if (element instanceof LTCDomain) {
            return LITECOIN;
        } else if (element instanceof GBPDomain) {
            return GBP;
        } else if (element instanceof ARSDomain) {
            return ARS;
        }

        return position;
    }


}

