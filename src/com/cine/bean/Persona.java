package com.cine.bean;

public abstract class Persona {
	private int idPersona;
	private String nombrePer;
	private String cedulaPer;
	private String correo;

	public Persona(int idPersona, String nombrePer, String cedulaPer, String correo) {
		this.idPersona = idPersona;
		this.nombrePer = nombrePer;
		this.cedulaPer = cedulaPer;
		this.correo = correo;
	}

	// Getters y setters

	public int getIdPersona() {
		return idPersona;
	}

	public String getNombrePer() {
		return nombrePer;
	}

	public String getCedulaPer() {
		return cedulaPer;
	}

	public String getCorreo() {
		return correo;
	}


	@Override
	public String toString() {
		return "idPersona: " + idPersona + ", nombrePer: " + nombrePer + ", cedulaPer: " + cedulaPer + ", correo: "
				+ correo;
	}
}
