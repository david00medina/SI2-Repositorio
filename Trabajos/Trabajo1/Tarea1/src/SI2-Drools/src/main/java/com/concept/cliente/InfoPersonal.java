package com.concept.cliente;

import java.util.List;

import com.type.Interes;
import com.type.Educacion;
import com.type.Idioma;

public class InfoPersonal {
	private String nombre;
	private int edad;
	private int hijos;
	private boolean discapacidad;
	private List<Idioma> idioma;
	private List<Interes> intereses;
	private Educacion educacion;	
	

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		if (edad >= 18) {
			this.edad = edad;
		}
	}
	
	public int getHijos() {
		return hijos;
	}
	
	public void setHijos(int hijos) {
		this.hijos = hijos;
	}
	
	public boolean isDiscapacidad() {
		return discapacidad;
	}
	
	public void setDiscapacidad(boolean discapacidad) {
		this.discapacidad = discapacidad;
	}
	
	public List<Idioma> getIdioma() {
		return idioma;
	}
	
	public void setIdioma(List<Idioma> idioma) {
		if (idioma.size() > 0 && idioma != null) {
			this.idioma = idioma;
		}
	}
	
	public List<Interes> getIntereses() {
		return intereses;
	}
	
	public void setIntereses(List<Interes> interes) {
		if (interes.size() > 0 && interes.size() <= 3 && interes != null) {
			this.intereses = interes;
		}
	}
	
	public Educacion getEducacion() {
		return educacion;
	}
	
	public void setEducacion(Educacion educacion) {
		this.educacion = educacion;
	}
}
