package com.bolsadeideas.springboot.web.app.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_Cuenta;
	private int id_Inscripcion;
	private int saldo;
	private Date fecha;
	private Time hora;

	public Cuenta() {

	}

	public Cuenta(int id_Cuenta, int id_Inscripcion, int saldo, Date fecha, Time hora) {
		super();
		this.id_Cuenta = id_Cuenta;
		this.id_Inscripcion = id_Inscripcion;
		this.saldo = saldo;
		this.fecha = fecha;
		this.hora = hora;
	}

	public int getId_Cuenta() {
		return id_Cuenta;
	}

	public void setId_Cuenta(int id_Cuenta) {
		this.id_Cuenta = id_Cuenta;
	}

	public int getId_Inscripcion() {
		return id_Inscripcion;
	}

	public void setId_Inscripcion(int id_Inscripcion) {
		this.id_Inscripcion = id_Inscripcion;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cuenta [id_Cuenta=" + id_Cuenta + ", id_Inscripcion=" + id_Inscripcion + ", saldo=" + saldo + ", fecha="
				+ fecha + ", hora=" + hora + "]\n";
	}


}
