package com.concept.cliente;

import com.type.TipoEdad;

public abstract class ClienteAbstracto {
	private TipoEdad tipoEdad;
	private int fisico = 1;
	private int cultura = 1;
	private int entretenimiento = 1;

	public TipoEdad getTipoEdad() {
		return tipoEdad;
	}
	
	public void setTipoEdad(TipoEdad tipoEdad) {
		this.tipoEdad = tipoEdad;
	}
	
	public int getFisico() {
		return fisico;
	}
	
	public void setFisico(int fisico) {
		if (fisico > 0 && fisico <= 5) {
			this.fisico = fisico;
		} else if (fisico <= 0) {
			this.fisico = 1;
		} else {
			this.fisico = 5;
		}
	}
	
	public int getCultura() {
		return cultura;
	}
	
	public void setCultura(int cultura) {
		if (cultura > 0 && cultura <= 5) {
			this.cultura = cultura;
		} else if (cultura <= 0) {
			this.cultura = 1;
		} else {
			this.cultura = 5;
		}
	}
	
	public int getEntretenimiento() {
		return entretenimiento;
	}
	
	public void setEntretenimiento(int entretenimiento) {
		if (entretenimiento > 0 && entretenimiento <= 5) {
			this.entretenimiento = entretenimiento;
		} else if (entretenimiento <= 0) {
			this.entretenimiento = 1;
		} else {
			this.entretenimiento = 5;
		}
	}
	
	
}
