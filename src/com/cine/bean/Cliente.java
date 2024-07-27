package com.cine.bean;

import com.cine.intancias.PersonaBuilder;

public class Cliente extends Persona {
	private int idCliente;
	private String direccionCli;
	private String telefonoCli;

	private Cliente(Builder builder) {
		super(builder.idPersona, builder.nombrePer, builder.cedulaPer, builder.correo);
		this.idCliente = builder.idCliente;
		this.direccionCli = builder.direccionCli;
		this.telefonoCli = builder.telefonoCli;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getDireccionCli() {
		return direccionCli;
	}

	public String getTelefonoCli() {
		return telefonoCli;
	}

	public static class Builder implements PersonaBuilder{
		private int idPersona;
		private String nombrePer;
		private String cedulaPer;
		private String correo;
		private String telefonoCli;
		private int idCliente;
		private String direccionCli;

		public Builder idPersona(int idPersona) {
			this.idPersona = idPersona;
			return this;
		}

		public Builder nombrePer(String nombrePer) {
			this.nombrePer = nombrePer;
			return this;
		}

		public Builder cedulaPer(String cedulaPer) {
			this.cedulaPer = cedulaPer;
			return this;
		}

		public Builder correo(String correo) {
			this.correo = correo;
			return this;
		}

		public Builder telefonoCli(String telefonoCli) {
			this.telefonoCli = telefonoCli;
			return this;
		}

		public Builder idCliente(int idCliente) {
			this.idCliente = idCliente;
			return this;
		}

		public Builder direccionCli(String direccionCli) {
			this.direccionCli = direccionCli;
			return this;
		}
		@Override
		public Cliente build() {
			return new Cliente(this);
		}
	}

	@Override
	public String toString() {
		return super.toString()+" Cliente [idCliente=" + idCliente + ", direccionCli=" + direccionCli + ", telefonoCli=" + telefonoCli
				+ "]";
	}
}
