package com.pedrosoares.cotacaoapp.data.entity;

import com.google.gson.annotations.SerializedName;

public class CoinsResponse{

	@SerializedName("AUDDomain")
	private AUD aUD;

	@SerializedName("BTCDomain")
	private BTC bTC;

	@SerializedName("CHFDomain")
	private CHF cHF;

	@SerializedName("ARSDomain")
	private ARS aRS;

	@SerializedName("JPYDomain")
	private JPY jPY;

	@SerializedName("EURDomain")
	private EUR eUR;

	@SerializedName("GBPDomain")
	private GBP gBP;

	@SerializedName("USDDomain")
	private USD uSD;

	@SerializedName("CADDomain")
	private CAD cAD;

	@SerializedName("USDTDomain")
	private USDT uSDT;

	@SerializedName("LTCDomain")
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