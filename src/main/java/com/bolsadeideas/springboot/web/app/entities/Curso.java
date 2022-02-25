package com.bolsadeideas.springboot.web.app.entities;

import java.io.Serializable;

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idCurso;
	private String descripcion;

	public Curso() {

	}

	public Curso(int idCurso, String descripcion) {
		super();
		this.idCurso = idCurso;
		this.descripcion = descripcion;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
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
		return "Curso [idCurso=" + idCurso + ", descripcion=" + descripcion + "]\n";
	}

}
