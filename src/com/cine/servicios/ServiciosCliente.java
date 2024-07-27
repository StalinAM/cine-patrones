package com.cine.servicios;

import java.sql.SQLException;
import java.util.List;

import com.cine.bean.Cliente;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public interface ServiciosCliente {
	
public void setDbConfig(BaseDatosConexion dbConfig);
	
	//CRUD
	public Cliente buscarPorId(Integer id) throws SQLException;//C
	public List<Cliente> listarTodos() throws SQLException;//R
	public void crear (Cliente obj) throws SQLException;//R
	public void actualizar (Cliente obj) throws SQLException;//U
	public void eliminarPorId(Integer id) throws SQLException;//D

}
