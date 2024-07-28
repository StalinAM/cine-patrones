package com.cine.bean;

import com.cine.intancias.PersonaBuilder;

public class Empleado extends Persona {
	private int idEmpleado;
	private String cargoEmpl;
	private String cuentaBancariaEmpl;
	private String usuarioEmpl;
	private String contraseniaEmpl;

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public String getCargoEmpl() {
		return cargoEmpl;
	}

	public String getCuentaBancariaEmpl() {
		return cuentaBancariaEmpl;
	}

	public String getUsuarioEmpl() {
		return usuarioEmpl;
	}

	public String getContraseniaEmpl() {
		return contraseniaEmpl;
	}

	private Empleado(Builder builder) {
		super(builder.idPersona, builder.nombrePer, builder.cedulaPer, builder.correo);
		this.idEmpleado = builder.idEmpleado;
		this.cargoEmpl = builder.cargoEmpl;
		this.cuentaBancariaEmpl = builder.cuentaBancariaEmpl;

		this.usuarioEmpl = builder.usuarioEmpl;
		this.contraseniaEmpl = builder.contraseniaEmpl;
	}

	public static class Builder implements PersonaBuilder {
		private int idPersona;
		private String nombrePer;
		private String cedulaPer;
		private String correo;
		private int idEmpleado;
		private String cargoEmpl;
		private String cuentaBancariaEmpl;
		private String usuarioEmpl;
		private String contraseniaEmpl;

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

		public Builder idEmpleado(int idEmpleado) {
			this.idEmpleado = idEmpleado;
			return this;
		}

		public Builder cargoEmpl(String cargoEmpl) {
			this.cargoEmpl = cargoEmpl;
			return this;
		}

		public Builder cuentaBancariaEmpl(String cuentaBancariaEmpl) {
			this.cuentaBancariaEmpl = cuentaBancariaEmpl;
			return this;
		}

		public Builder usuarioEmpl(String usuarioEmpl) {
			this.usuarioEmpl = usuarioEmpl;
			return this;
		}

		public Builder contraseniaEmpl(String contraseniaEmpl) {
			this.contraseniaEmpl = contraseniaEmpl;
			return this;
		}

		@Override
		public Empleado build() {
			return new Empleado(this);
		}

	}

	@Override
	public String toString() {
		return "Empleado{" + super.toString() + ", idEmpleado: " + idEmpleado + ", cargoEmpl: " + cargoEmpl
				+ ", cuentaBancariaEmpl: " + cuentaBancariaEmpl + ", usuarioEmpl: " + usuarioEmpl
				+ ", contraseniaEmpl: " + contraseniaEmpl + "}";
	}

}
