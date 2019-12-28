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

	@SerializedName("XRP")
	private XRP xrp;

	@SerializedName("ETH")
	private ETH eth;


	public BTC getBTC(){
		return bTC;
	}

	public ARS getARS(){
		return aRS;
	}

	public EUR getEUR(){
		return eUR;
	}

	public GBP getGBP(){
		return gBP;
	}

	public USD getUSD(){
		return uSD;
	}

	public LTC getLTC(){
		return lTC;
	}

	public XRP getXrp() {
		return xrp;
	}

	public ETH getEth() {
		return eth;
	}
}