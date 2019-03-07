package com.pedrosoares.cotacaoapp.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.BTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.EURDomain;
import com.pedrosoares.cotacaoapp.model.domain.GBPDomain;
import com.pedrosoares.cotacaoapp.model.domain.LTCDomain;
import com.pedrosoares.cotacaoapp.model.domain.USDDomain;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.BitCoinViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.DolarViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.EuroViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.LibraViewHolder;
import com.pedrosoares.cotacaoapp.presentation.view.viewholder.LiteCoinViewHolder;

import java.util.List;

import butterknife.Bind;

public class CotacaoAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    private Context context;
    private static final int USD_COIN = 0;
    private static final int EURO_COIN = 1;
    private static final int BITCOIN = 2;
    private static final int LITECOIN = 3;
    private static final int GBP = 4;
    private List<Object> coinsDomainList;

    public CotacaoAdapter(Context context, List<Object> coinsDomainList){
        this.context = context;
        this.coinsDomainList = coinsDomainList;
    }

    @NonNull
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_cotacao, parent, false);

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
        } else if (element instanceof USDDomain) {
            return USD_COIN;
        } else if (element instanceof LTCDomain) {
            return LITECOIN;
        } else if(element instanceof GBPDomain) {
            return GBP;
        }
        else
            Toast.makeText(context, "Erro ao carregar lista de moedas", Toast.LENGTH_SHORT).show();

        return 0;
    }


}

