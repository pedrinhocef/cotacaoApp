package com.pedrosoares.cotacaoapp.presentation.adapter;

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
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CotacaoAdapter  extends RecyclerView.Adapter<BaseViewHolder>{

    //private CotacaoListener listener;
    private Context context;
    private static final int USD_COIN = 0;
    private static final int EURO_COIN = 1;
    private static final int BITCOIN = 2;
    private static final int LITECOIN = 3;
    private List<Comparable> data;
    private List<CoinsDomain> coinsDomainList;
    private CoinsDomain coinsDomain;


    public CotacaoAdapter(Context context, List<CoinsDomain> coinsDomainList){
        this.context = context;
        this.coinsDomainList = coinsDomainList;
        //this.listener = listener;
    }

    public void addTo(List coinsDomainsList) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.clear();
        data.addAll(coinsDomainsList);
        notifyDataSetChanged();
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
                return new BitCoinViewHolder(view);
            }
            case LITECOIN: {
                return new LiteCoinViewHolder(view);
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
    public int getItemCount() {
        return coinsDomainList.size();
    }

    public int getItemViewType(int position) {
        Comparable element = data.get(position);

        if(element instanceof DolarViewHolder) {
            return USD_COIN;
        } else if(element instanceof EuroViewHolder) {
            return EURO_COIN;
        }else if(element instanceof  BitCoinViewHolder){
            return BITCOIN;
        }else if(element instanceof LiteCoinViewHolder){
            return LITECOIN;
        }else Toast.makeText(context,"Erro ao carregar lista de moedas",Toast.LENGTH_SHORT).show();

        return -1;
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

 public static class BitCoinViewHolder extends BaseViewHolder<CoinsDomain> {

     @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

     @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

     public BitCoinViewHolder(@NonNull View itemView) {
         super(itemView);
     }

     @Override
     public void bind(CoinsDomain coinsDomain) {
         tvCoinName.setText(coinsDomain.getBTC().getName());
         tvCoinValue.setText(coinsDomain.getBTC().getBid());
     }
 }

 public static class LiteCoinViewHolder extends BaseViewHolder<CoinsDomain> {

     @Bind(R.id.tv_coin_name)
     TextView tvCoinName;

     @Bind(R.id.tv_coin_value)
     TextView tvCoinValue;

     public LiteCoinViewHolder(@NonNull View itemView) {
         super(itemView);
     }

     @Override
     public void bind(CoinsDomain coinsDomain) {
         tvCoinName.setText(coinsDomain.getLTC().getName());
         tvCoinValue.setText(coinsDomain.getLTC().getBid());
     }
 }



}

