package com.cine.servicios;

import java.util.List;

import com.cine.bean.*;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public interface ServiciosEmpleado {
	
public void setDbConfig(BaseDatosConexion dbConfig);
	
	//CRUD
	public Persona buscarPorId(Integer id);//C
	public List<Persona> listarTodos();//R
	public void crear (Persona obj);//R
	public void actualizar (Persona obj);//U
	public void eliminarPorId(int id);//D

}
