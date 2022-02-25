package com.bolsadeideas.springboot.web.app.entities;

import java.io.Serializable;

public class Materia implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idMateria;
	private String descripcion;

	public Materia() {

	}

	public Materia(int idMateria, String descripcion) {

		this.idMateria = idMateria;
		this.descripcion = descripcion;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", descripcion=" + descripcion + "]\n";
	}

}
