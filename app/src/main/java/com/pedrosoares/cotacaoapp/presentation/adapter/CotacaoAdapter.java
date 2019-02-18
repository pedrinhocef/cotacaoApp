package com.pedrosoares.cotacaoapp.presentation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedrosoares.cotacaoapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CotacaoAdapter  extends RecyclerView.Adapter<CotacaoAdapter.ViewHolder>{

    private CotacaoListener listener;
    private Context context;

    public CotacaoAdapter(Context context, CotacaoListener listener){
        this.context = context;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.rv_list_cambio)
        RecyclerView rvListCambio;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cotacao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.rvListCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }


}
