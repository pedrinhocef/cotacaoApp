package com.pedrosoares.cotacaoapp.presentation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.core.base.BaseViewHolder;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CotacaoAdapter  extends RecyclerView.Adapter<BaseViewHolder>{

    //private CotacaoListener listener;
    private Context context;
    private static final int USD_COIN = 0;
    private static final int EURO_COIN = 1;
    private static final int BITCOIN = 2;
    private List<CoinsDomain> coinsDomainList;


    public CotacaoAdapter(Context context, List<CoinsDomain> coinsDomainList){
        this.context = context;
        this.coinsDomainList = coinsDomainList;
        //this.listener = listener;
    }


    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cotacao, parent, false);

        switch(viewType){
            case USD_COIN: {
                return new DolarViewHolder(view);
            }
            case EURO_COIN: {
                return new EuroViewHolder(view);
            }
            case BITCOIN: {
                return new BitCoinsViewHolder(view);
            }
            default:{
                throw new IllegalArgumentException("Invalid view type");
            }
        }
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
       //Comparable element = data.get(position);
       CoinsDomain coinsDomain = coinsDomainList.get(position);
       holder.bind(coinsDomain);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return coinsDomainList.size();
    }

/////////////////////////////////////////////////////////////////



 public static class DolarViewHolder extends BaseViewHolder<CoinsDomain>{

     @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

     @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

     public DolarViewHolder(@NonNull View itemView) {
         super(itemView);
     }

     @Override
     public void bind(CoinsDomain coinsDomain) {
         tvCoinName.setText(coinsDomain.getUSD().getName());
         tvCoinValue.setText(coinsDomain.getUSD().getBid());
     }
 }

 public static class EuroViewHolder extends BaseViewHolder<CoinsDomain> {

     @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

     @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

     public EuroViewHolder(@NonNull View itemView) {
         super(itemView);
     }

     @Override
     public void bind(CoinsDomain coinsDomain) {
         tvCoinName.setText(coinsDomain.getEUR().getName());
         tvCoinValue.setText(coinsDomain.getEUR().getBid());
     }

 }

 public static class BitCoinsViewHolder extends BaseViewHolder<CoinsDomain> {

     @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

     @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

     public BitCoinsViewHolder(@NonNull View itemView) {
         super(itemView);
     }

     @Override
     public void bind(CoinsDomain coinsDomain) {
         tvCoinName.setText(coinsDomain.getBTC().getName());
         tvCoinValue.setText(coinsDomain.getBTC().getBid());
     }
 }



}

