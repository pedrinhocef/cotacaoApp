package com.pedrosoares.cotacaoapp.model.domain;

import android.support.annotation.NonNull;

public class CoinsDomain implements Comparable{
	private AUDDomain aUD;
	private BTCDomain bTC;
	private CHFDomain cHF;
	private ARSDomain aRS;
	private JPYDomain jPY;
	private EURDomain eUR;
	private GBPDomain gBP;
	private USDDomain uSD;
	private CADDomain cAD;
	private USDTDomain uSDT;
	private LTCDomain lTC;

	public void setAUD(AUDDomain aUD){
		this.aUD = aUD;
	}

	public AUDDomain getAUD(){
		return aUD;
	}

	public void setBTC(BTCDomain bTC){
		this.bTC = bTC;
	}

	public BTCDomain getBTC(){
		return bTC;
	}

	public void setCHF(CHFDomain cHF){
		this.cHF = cHF;
	}

	public CHFDomain getCHF(){
		return cHF;
	}

	public void setARS(ARSDomain aRS){
		this.aRS = aRS;
	}

	public ARSDomain getARS(){
		return aRS;
	}

	public void setJPY(JPYDomain jPY){
		this.jPY = jPY;
	}

	public JPYDomain getJPY(){
		return jPY;
	}

	public void setEUR(EURDomain eUR){
		this.eUR = eUR;
	}

	public EURDomain getEUR(){
		return eUR;
	}

	public void setGBP(GBPDomain gBP){
		this.gBP = gBP;
	}

	public GBPDomain getGBP(){
		return gBP;
	}

	public void setUSD(USDDomain uSD){
		this.uSD = uSD;
	}

	public USDDomain getUSD(){
		return uSD;
	}

	public void setCAD(CADDomain cAD){
		this.cAD = cAD;
	}

	public CADDomain getCAD(){
		return cAD;
	}

	public void setUSDT(USDTDomain uSDT){
		this.uSDT = uSDT;
	}

	public USDTDomain getUSDT(){
		return uSDT;
	}

	public void setLTC(LTCDomain lTC){
		this.lTC = lTC;
	}

	public LTCDomain getLTC(){
		return lTC;
	}

	@Override
	public int compareTo(@NonNull Object o) {
		return 0;
	}
}
