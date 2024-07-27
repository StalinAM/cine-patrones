package com.cine.intancias;

import com.cine.bean.Cliente;
import com.cine.bean.Empleado;
import com.cine.bean.Persona;

public class FactoryImpl {

	public Persona crearProducto(TipoPersona tipoProducto, PersonaBuilder builder) {

		switch (tipoProducto) {
		case CLIENTE:
			return ((Cliente.Builder) builder).build();
		case EMPLEADO:
			return ((Empleado.Builder) builder).build();
		default:
			throw new IllegalArgumentException("Tipo de producto no soportado");
		}

	}

}
