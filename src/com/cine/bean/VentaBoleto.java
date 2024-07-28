package com.cine.bean;

public class VentaBoleto {

	private int idVentaBoleto;
	private int cantidadVentaBoleto;
	private String asientosVentaBoleto;
	private int idEventoProy;
	private int idCli;
	private int idEmp;

	public VentaBoleto(int idVentaBoleto, int cantidadVentaBoleto, String asientosVentaBoleto, int idEventoProy,
			int idCli, int idEmp) {
		super();
		this.idVentaBoleto = idVentaBoleto;
		this.cantidadVentaBoleto = cantidadVentaBoleto;
		this.asientosVentaBoleto = asientosVentaBoleto;
		this.idEventoProy = idEventoProy;
		this.idCli = idCli;
		this.idEmp = idEmp;
	}

	public int getIdVentaBoleto() {
		return idVentaBoleto;
	}

	public void setIdVentaBoleto(int idVentaBoleto) {
		this.idVentaBoleto = idVentaBoleto;
	}

	public int getCantidadVentaBoleto() {
		return cantidadVentaBoleto;
	}

	public void setCantidadVentaBoleto(int cantidadVentaBoleto) {
		this.cantidadVentaBoleto = cantidadVentaBoleto;
	}

	public String getAsientosVentaBoleto() {
		return asientosVentaBoleto;
	}

	public void setAsientosVentaBoleto(String asientosVentaBoleto) {
		this.asientosVentaBoleto = asientosVentaBoleto;
	}

	public int getIdEventoProy() {
		return idEventoProy;
	}

	public void setIdEventoProy(int idEventoProy) {
		this.idEventoProy = idEventoProy;
	}

	public int getIdCli() {
		return idCli;
	}

	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	@Override
	public String toString() {
		return "VentaBoleto [idVentaBoleto=" + idVentaBoleto + ", cantidadVentaBoleto=" + cantidadVentaBoleto
				+ ", asientosVentaBoleto=" + asientosVentaBoleto + ", idEventoProy=" + idEventoProy + ", idCli=" + idCli
				+ ", idEmp=" + idEmp + "]";
	}

}
