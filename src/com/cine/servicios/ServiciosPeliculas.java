package com.cine.servicios;

import java.sql.SQLException;
import java.util.List;

import com.cine.bean.Cliente;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public interface ServiciosPeliculas {
	
public void setDbConfig(BaseDatosConexion dbConfig);
	
	//CRUD
	public Cliente buscarPorId(Integer id);//C
	public List<Cliente> listarTodos();//R
	public void crear (Object obj);//R
	public void actualizar (Cliente obj);//U
	public void eliminarPorId(Integer id);//D

}
