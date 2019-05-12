package com.concept.criterion;

import com.concept.destino.Destino;

public abstract class CriterioDestino {
	private boolean cumpleCriterio = false;
	private Destino destino;

	public CriterioDestino(Destino destino) {
		this.destino = destino;
	}

	public boolean isCumpleCriterio() {
		return cumpleCriterio;
	}

	public void setCumpleCriterio(boolean cumpleCriterio) {
		this.cumpleCriterio = cumpleCriterio;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
}
