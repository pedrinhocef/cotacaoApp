package com.pedrosoares.cotacaoapp.data.entity;

import com.google.gson.annotations.SerializedName;

public class Coins {

    @SerializedName("USD")
    public USD usd;
    @SerializedName("EUR")
    public EUR eur;
    @SerializedName("GBP")
    public GBP gbp;
    @SerializedName("ARS")
    public ARS ars;
    @SerializedName("USDT")
    public USDT usdt;
    @SerializedName("CAD")
    public CAD cad;
    @SerializedName("BTC")
    public BTC btc;
}
