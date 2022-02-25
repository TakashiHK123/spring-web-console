package com.bolsadeideas.springboot.web.app.entities;

import java.io.Serializable;

public class Inscripciones implements Serializable{


	private static final long serialVersionUID = 1L;
	private int idInscripciones; 
	private int idCursoHabilitado;
	private int idAlumno;
	
	public Inscripciones() {
		
	}

	public Inscripciones(int idInscripciones, int idCursoHabilitado, int idAlumno) {
		super();
		this.idInscripciones = idInscripciones;
		this.idCursoHabilitado = idCursoHabilitado;
		this.idAlumno = idAlumno;
	}

	public int getIdInscripciones() {
		return idInscripciones;
	}

	public void setIdInscripciones(int idInscripciones) {
		this.idInscripciones = idInscripciones;
	}

	public int getIdCursoHabilitado() {
		return idCursoHabilitado;
	}

	public void setIdCursoHabilitado(int idCursoHabilitado) {
		this.idCursoHabilitado = idCursoHabilitado;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Inscripciones [idInscripciones=" + idInscripciones + ", idCursoHabilitado=" + idCursoHabilitado
				+ ", idAlumno=" + idAlumno + "]\n";
	} 
	
	
	
}
