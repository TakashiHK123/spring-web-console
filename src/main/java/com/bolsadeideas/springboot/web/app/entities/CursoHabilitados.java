package com.bolsadeideas.springboot.web.app.entities;

import java.io.Serializable;

public class CursoHabilitados implements Serializable{


	private static final long serialVersionUID = 1L;
	private int idCursoHabilitado; 
	private int idCurso;
	private int idMateria;
	private int idProfesor;
	
	public CursoHabilitados() {
		
	}

	public CursoHabilitados(int idCursoHabilitado, int idCurso, int idMateria, int idProfesor) {
		super();
		this.idCursoHabilitado = idCursoHabilitado;
		this.idCurso = idCurso;
		this.idMateria = idMateria;
		this.idProfesor = idProfesor;
	}

	public int getIdCursoHabilitado() {
		return idCursoHabilitado;
	}

	public void setIdCursoHabilitado(int idCursoHabilitado) {
		this.idCursoHabilitado = idCursoHabilitado;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CursoHabilitados [idCursoHabilitado=" + idCursoHabilitado + ", idCurso=" + idCurso + ", idMateria="
				+ idMateria + ", idProfesor=" + idProfesor + "]\n";
	} 
	
	
}
