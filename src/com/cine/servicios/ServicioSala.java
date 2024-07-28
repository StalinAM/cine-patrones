package com.cine.servicios;

import java.util.List;
import com.cine.bean.Sala;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public interface ServicioSala {

	public void setDbConfig(BaseDatosConexion dbConfig);

	// CRUD
	public Sala buscarPorId(Integer id);// C

	public List<Sala> listarTodos();// R

	public void crear(Sala obj);// R

	public void actualizar(Sala obj);// U

	public void eliminarPorId(Integer id);// D

}
