package com.concept.cliente;

public class Cliente extends ClienteAbstracto {
	private InfoPersonal infoPersonal;
	private InfoEconomica infoEconomica;
	
	public InfoPersonal getInfoPersonal() {
		return infoPersonal;
	}
	
	public void setInfoPersonal(InfoPersonal infoPersonal) {
		this.infoPersonal = infoPersonal;
	}
	
	public InfoEconomica getInfoEconomica() {
		return infoEconomica;
	}
	
	public void setInfoEconomica(InfoEconomica infoEconomica) {
		this.infoEconomica = infoEconomica;
	}
}
