package com.pedrosoares.cotacaoapp.data.entity;

import com.google.gson.annotations.SerializedName;

public class CoinsResponse{

	@SerializedName("AUD")
	private AUD aUD;

	@SerializedName("BTC")
	private BTC bTC;

	@SerializedName("CHF")
	private CHF cHF;

	@SerializedName("ARS")
	private ARS aRS;

	@SerializedName("JPY")
	private JPY jPY;

	@SerializedName("EUR")
	private EUR eUR;

	@SerializedName("GBP")
	private GBP gBP;

	@SerializedName("USD")
	private USD uSD;

	@SerializedName("CAD")
	private CAD cAD;

	@SerializedName("USDT")
	private USDT uSDT;

	@SerializedName("LTC")
	private LTC lTC;

	public void setAUD(AUD aUD){
		this.aUD = aUD;
	}

	public AUD getAUD(){
		return aUD;
	}

	public void setBTC(BTC bTC){
		this.bTC = bTC;
	}

	public BTC getBTC(){
		return bTC;
	}

	public void setCHF(CHF cHF){
		this.cHF = cHF;
	}

	public CHF getCHF(){
		return cHF;
	}

	public void setARS(ARS aRS){
		this.aRS = aRS;
	}

	public ARS getARS(){
		return aRS;
	}

	public void setJPY(JPY jPY){
		this.jPY = jPY;
	}

	public JPY getJPY(){
		return jPY;
	}

	public void setEUR(EUR eUR){
		this.eUR = eUR;
	}

	public EUR getEUR(){
		return eUR;
	}

	public void setGBP(GBP gBP){
		this.gBP = gBP;
	}

	public GBP getGBP(){
		return gBP;
	}

	public void setUSD(USD uSD){
		this.uSD = uSD;
	}

	public USD getUSD(){
		return uSD;
	}

	public void setCAD(CAD cAD){
		this.cAD = cAD;
	}

	public CAD getCAD(){
		return cAD;
	}

	public void setUSDT(USDT uSDT){
		this.uSDT = uSDT;
	}

	public USDT getUSDT(){
		return uSDT;
	}

	public void setLTC(LTC lTC){
		this.lTC = lTC;
	}

	public LTC getLTC(){
		return lTC;
	}
}