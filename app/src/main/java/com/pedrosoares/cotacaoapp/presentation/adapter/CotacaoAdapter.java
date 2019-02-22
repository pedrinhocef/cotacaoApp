package com.pedrosoares.cotacaoapp.presentation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pedrosoares.cotacaoapp.R;
import com.pedrosoares.cotacaoapp.model.domain.CoinsDomain;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CotacaoAdapter  extends RecyclerView.Adapter<CotacaoAdapter.CotacaoViewHolder>{

    private Context context;
    private List<CoinsDomain> listCoins;

    public CotacaoAdapter(Context context, List<CoinsDomain> listCoins){
        this.context = context;
        this.listCoins = listCoins;
    }


    public CotacaoAdapter.CotacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cotacao, parent, false);
        return new CotacaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CotacaoViewHolder holder, int position) {
        CoinsDomain coinsDomain = listCoins.get(position);

        holder.tvCoinName.setText(coinsDomain.getUSD().getName());
        holder.tvCoinValue.setText(coinsDomain.getUSD().getBid());


    }

    @Override
    public int getItemCount() {
        return listCoins.size();
    }
/////////////////////////////////////////////////////////////////



    class CotacaoViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.tv_coin_name)
        TextView tvCoinName;

        @Bind(R.id.tv_alert)
        TextView tvAlert;

        @Bind(R.id.tv_coin_value)
        TextView tvCoinValue;


        public CotacaoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            setIsRecyclable(false);
        }
    }



}
