package com.pedrosoares.cotacaoapp.data.entity;

import com.google.gson.annotations.SerializedName;

public class USD{

	@SerializedName("varBid")
	private String varBid;

	@SerializedName("high")
	private String high;

	@SerializedName("pctChange")
	private String pctChange;

	@SerializedName("code")
	private String code;

	@SerializedName("low")
	private String low;

	@SerializedName("codein")
	private String codein;

	@SerializedName("name")
	private String name;

	@SerializedName("ask")
	private String ask;

	@SerializedName("bid")
	private String bid;

	@SerializedName("create_date")
	private String createDate;

	@SerializedName("timestamp")
	private String timestamp;

	public void setVarBid(String varBid){
		this.varBid = varBid;
	}

	public String getVarBid(){
		return varBid;
	}

	public void setHigh(String high){
		this.high = high;
	}

	public String getHigh(){
		return high;
	}

	public void setPctChange(String pctChange){
		this.pctChange = pctChange;
	}

	public String getPctChange(){
		return pctChange;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setLow(String low){
		this.low = low;
	}

	public String getLow(){
		return low;
	}

	public void setCodein(String codein){
		this.codein = codein;
	}

	public String getCodein(){
		return codein;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAsk(String ask){
		this.ask = ask;
	}

	public String getAsk(){
		return ask;
	}

	public void setBid(String bid){
		this.bid = bid;
	}

	public String getBid(){
		return bid;
	}

	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}

	public String getCreateDate(){
		return createDate;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}
}