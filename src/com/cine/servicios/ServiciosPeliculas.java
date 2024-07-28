package com.cine.servicios;

import java.util.List;

import com.cine.bean.Pelicula;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public interface ServiciosPeliculas {

	public void setDbConfig(BaseDatosConexion dbConfig);

	// CRUD
	public Pelicula buscarPorId(Integer id);// C

	public List<Pelicula> listarTodos();// R

	public void crear(Pelicula obj);// R

	public void actualizar(Pelicula obj);// U

	public void eliminarPorId(Integer id);// D

}
