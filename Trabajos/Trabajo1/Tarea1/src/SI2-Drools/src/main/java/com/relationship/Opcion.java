package com.relationship;

import java.util.Calendar;
import java.util.Date;

import com.concept.cliente.Cliente;
import com.concept.destino.Destino;
import com.concept.match.ResultadoValoracion;

public class Opcion {
	private Cliente cliente;
	private Destino destino;
	private Date fecha;
	private ResultadoValoracion resultadoValoracion;
	
	public Opcion() {
		fecha = Calendar.getInstance().getTime();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Destino getDestino() {
		return destino;
	}
	
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ResultadoValoracion getResultadoValoracion() {
		return resultadoValoracion;
	}

	public void setResultadoValoracion(ResultadoValoracion resultadoValoracion) {
		this.resultadoValoracion = resultadoValoracion;
	}
	
}
