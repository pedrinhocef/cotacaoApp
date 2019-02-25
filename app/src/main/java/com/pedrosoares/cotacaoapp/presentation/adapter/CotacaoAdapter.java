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
    private CoinsDomain coinsDomains ;
    private Context context;
    private static final int USD_COIN = 0;
    private static final int EURO_COIN = 1;
    private static final int BITCOIN = 2;
    List<Comparable> data;


    public CotacaoAdapter(Context context){
        this.context = context;
        //this.listener = listener;
    }


    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cotacao, parent, false);
//
//        BaseViewHolder baseViewHolder;
//        if (viewType == )
//
//
//
//        if (holder == )
        //return new BaseViewHolder(view);
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {



        if (getItemViewType(position) == USD_COIN) {
            DolarViewHolder usd = (DolarViewHolder) holder;
            usd.tvCoinName.setText(coinsDomains.getUSD().getName());
            usd.tvCoinValue.setText(coinsDomains.getUSD().getBid());
        } else if (getItemViewType(position) == EURO_COIN) {
//            usd = new DolarViewHolder(holder.itemView);
//            usd.tvCoinName.setText();
//            usd.tvCoinValue.setText();
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object object = data.get(position);

        if(object instanceof DolarViewHolder) {
            return USD_COIN;
        } else if(object instanceof EuroViewHolder) {
            return EURO_COIN;
        }else {
            return BITCOIN;
        }
    }
/////////////////////////////////////////////////////////////////



 public static class DolarViewHolder extends BaseViewHolder{

     @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

     @Bind(R.id.tv_alert)
     TextView tvAlert;

     @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;


     public DolarViewHolder(@NonNull View itemView) {
         super(itemView);
     }

 }

 public static class EuroViewHolder extends BaseViewHolder{

        @Bind(R.id.tv_coin_name)
        TextView tvCoinName;

        @Bind(R.id.tv_alert)
        TextView tvAlert;

        @Bind(R.id.tv_coin_value)
        TextView tvCoinValue;




        public EuroViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


 public static class BitCoinViewHolder extends BaseViewHolder{

        @Bind(R.id.tv_coin_name)
        TextView tvCoinName;

        @Bind(R.id.tv_alert)
        TextView tvAlert;

        @Bind(R.id.tv_coin_value)
        TextView tvCoinValue;


        public BitCoinViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }





}

