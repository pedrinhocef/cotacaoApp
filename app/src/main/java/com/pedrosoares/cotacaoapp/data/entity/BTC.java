package com.pedrosoares.cotacaoapp.data.entity;

import com.google.gson.annotations.SerializedName;

public class BTC {

    @SerializedName("code")
    public String code;
    @SerializedName("codein")
    public String codein;
    @SerializedName("name")
    public String name;
    @SerializedName("high")
    public String high;
    @SerializedName("low")
    public String low;
    @SerializedName("pctChange")
    public String pctChange;
    @SerializedName("open")
    public String open;
    @SerializedName("bid")
    public String bid;
    @SerializedName("ask")
    public String ask;
    @SerializedName("varBid")
    public String varBid;
    @SerializedName("timestamp")
    public String timestamp;
    @SerializedName("create_date")
    public String createDate;
}
