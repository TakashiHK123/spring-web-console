package com.bolsadeideas.springboot.web.app.entities;

import java.io.Serializable;

public class Profesor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idProfe;
	private String nombre;
	private String apellido;
	
	public Profesor() {
		
	}

	public Profesor(int idProfe, String nombre, String apellido) {
		
		this.idProfe = idProfe;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getIdProfe() {
		return idProfe;
	}

	public void setIdProfe(int idProfe) {
		this.idProfe = idProfe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Profesor [idProfe=" + idProfe + ", nombre=" + nombre + ", apellido=" + apellido + "]\n";
	}
	
	
	
	
}

