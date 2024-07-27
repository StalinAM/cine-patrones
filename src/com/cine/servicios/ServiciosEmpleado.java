package com.cine.servicios;

import java.util.List;

import com.cine.bean.*;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public interface ServiciosEmpleado {
	
public void setDbConfig(BaseDatosConexion dbConfig);
	
	//CRUD
	public Empleado buscarPorId(Integer id);//C
	public List<Empleado> listarTodos();//R
	public void crear (Empleado obj);//R
	public void actualizar (Empleado obj);//U
	public void eliminarPorId(Integer id);//D

}
