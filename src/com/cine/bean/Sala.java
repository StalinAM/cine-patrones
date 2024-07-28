package com.cine.bean;

public class Sala {
	private int idSala;
	private String nombreSala;
	private int capacidadColumnaSala;
	private int capacidadFilaSala;

	public Sala(int idSala, String nombreSala, int capacidadColumnaSala, int capacidadFilaSala) {
		this.idSala = idSala;
		this.nombreSala = nombreSala;
		this.capacidadColumnaSala = capacidadColumnaSala;
		this.capacidadFilaSala = capacidadFilaSala;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public int getCapacidadColumnaSala() {
		return capacidadColumnaSala;
	}

	public void setCapacidadColumnaSala(int capacidadColumnaSala) {
		this.capacidadColumnaSala = capacidadColumnaSala;
	}

	public int getCapacidadFilaSala() {
		return capacidadFilaSala;
	}

	public void setCapacidadFilaSala(int capacidadFilaSala) {
		this.capacidadFilaSala = capacidadFilaSala;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nombreSala=" + nombreSala + ", capacidadColumnaSala="
				+ capacidadColumnaSala + ", capacidadFilaSala=" + capacidadFilaSala + "]";
	}

}
