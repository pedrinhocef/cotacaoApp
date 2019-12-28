package com.pedrosoares.cotacaoapp.model.domain;

public class CoinsDomain {

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
	private XRPDomain xrp;
	private ETHDomain eth;

	public void setBTC(BTCDomain bTC){
		this.bTC = bTC;
	}

	public BTCDomain getBTC(){
		return bTC;
	}

	public void setARS(ARSDomain aRS){
		this.aRS = aRS;
	}

	public ARSDomain getARS(){
		return aRS;
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

	public void setLTC(LTCDomain lTC){
		this.lTC = lTC;
	}

	public LTCDomain getLTC(){
		return lTC;
	}

	public XRPDomain getXrp() {
		return xrp;
	}

	public void setXrp(XRPDomain xrp) {
		this.xrp = xrp;
	}

	public ETHDomain getEth() {
		return eth;
	}

	public void setEth(ETHDomain eth) {
		this.eth = eth;
	}
}
