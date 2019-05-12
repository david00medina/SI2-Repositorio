package com.concept.destino;

import java.util.List;

import com.type.Interes;
import com.type.TipoEdad;

public class Destino extends Pais {
	private String destino;
	private List<TipoEdad> recomendacionEdad;
	private List<Interes> atractivoTuristico;
	private int umbralFisico = 1;
	private int umbralCultural = 1;
	private int umbralEntretenimiento = 1;

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public List<TipoEdad> getRecomendacionEdad() {
		return recomendacionEdad;
	}

	public void setRecomendacionEdad(List<TipoEdad> tipoEdad) {
		this.recomendacionEdad = tipoEdad;
	}

	public List<Interes> getAtractivoTuristico() {
		return atractivoTuristico;
	}

	public void setAtractivoTuristico(List<Interes> atractivoTuristico) {
		this.atractivoTuristico = atractivoTuristico;
	}

	public int getUmbralFisico() {
		return umbralFisico;
	}

	public void setUmbralFisico(int puntuacionFisica) {
		if (puntuacionFisica > 0 && puntuacionFisica <= 5) {
			this.umbralFisico = puntuacionFisica;
		} else if (puntuacionFisica <= 0) {
			this.umbralFisico = 1;
		} else {
			this.umbralFisico = 5;
		}
	}

	public int getUmbralCultural() {
		return umbralCultural;
	}

	public void setUmbralCultural(int puntuacionCultural) {
		if (puntuacionCultural > 0 && puntuacionCultural <= 5) {
			this.umbralCultural = puntuacionCultural;
		} else if (puntuacionCultural <= 0) {
			this.umbralCultural = 1;
		} else {
			this.umbralCultural = 5;
		}
	}

	public int getUmbralEntretenimiento() {
		return umbralEntretenimiento;
	}

	public void setUmbralEntretenimiento(int puntuacionEntretenimiento) {
		if (puntuacionEntretenimiento > 0 && puntuacionEntretenimiento <= 5) {
			this.umbralEntretenimiento = puntuacionEntretenimiento;
		} else if (puntuacionEntretenimiento <= 0) {
			this.umbralEntretenimiento = 1;
		} else {
			this.umbralEntretenimiento = 5;
		}
	}
}
