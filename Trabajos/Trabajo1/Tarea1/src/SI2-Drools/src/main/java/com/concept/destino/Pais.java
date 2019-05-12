package com.concept.destino;

import java.util.List;

import com.type.Idioma;

public abstract class Pais {
	private String pais;
	private float coste;
	private List<Idioma> idioma;

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public float getCoste() {
		return coste;
	}

	public void setCoste(float coste) {
		this.coste = coste;
	}

	public List<Idioma> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<Idioma> idioma) {
		if (idioma.size() > 0 && idioma != null) {
			this.idioma = idioma;
		}
	}
}
