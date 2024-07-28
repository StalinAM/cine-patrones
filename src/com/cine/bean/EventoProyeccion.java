package com.cine.bean;

public class EventoProyeccion {

	private int idEventPro;
	private String asientoUtilizadosEventoProy;
	private String fechaEventoProy;
	private String horaEventoProy;
	private float precioBoletoEventoProy;
	private int idSala;
	private int idPelicula;

	public EventoProyeccion(int idEventPro, String asientoUtilizadosEventoProy, String fechaEventoProy,
			String horaEventoProy, float precioBoletoEventoProy, int idSala, int idPelicula) {
		super();
		this.idEventPro = idEventPro;
		this.asientoUtilizadosEventoProy = asientoUtilizadosEventoProy;
		this.fechaEventoProy = fechaEventoProy;
		this.horaEventoProy = horaEventoProy;
		this.precioBoletoEventoProy = precioBoletoEventoProy;
		this.idSala = idSala;
		this.idPelicula = idPelicula;
	}

	public int getIdEventPro() {
		return idEventPro;
	}

	public void setIdEventPro(int idEventPro) {
		this.idEventPro = idEventPro;
	}

	public String getAsientoUtilizadosEventoProy() {
		return asientoUtilizadosEventoProy;
	}

	public void setAsientoUtilizadosEventoProy(String asientoUtilizadosEventoProy) {
		this.asientoUtilizadosEventoProy = asientoUtilizadosEventoProy;
	}

	public String getFechaEventoProy() {
		return fechaEventoProy;
	}

	public void setFechaEventoProy(String fechaEventoProy) {
		this.fechaEventoProy = fechaEventoProy;
	}

	public String getHoraEventoProy() {
		return horaEventoProy;
	}

	public void setHoraEventoProy(String horaEventoProy) {
		this.horaEventoProy = horaEventoProy;
	}

	public float getPrecioBoletoEventoProy() {
		return precioBoletoEventoProy;
	}

	public void setPrecioBoletoEventoProy(float precioBoletoEventoProy) {
		this.precioBoletoEventoProy = precioBoletoEventoProy;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	@Override
	public String toString() {
		return "EventoProyeccion [idEventPro=" + idEventPro + ", asientoUtilizadosEventoProy="
				+ asientoUtilizadosEventoProy + ", fechaEventoProy=" + fechaEventoProy + ", horaEventoProy="
				+ horaEventoProy + ", precioBoletoEventoProy=" + precioBoletoEventoProy + ", idSala=" + idSala
				+ ", idPelicula=" + idPelicula + "]";
	}

}
