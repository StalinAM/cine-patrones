package com.cine.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cine.bean.Pelicula;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public class ServiciosPeliculasImpl {

	private BaseDatosConexion dbConfig;

	public void setDbConfig(BaseDatosConexion dbConfig) {
		this.dbConfig = dbConfig;
	}

	public Pelicula buscarPorId(Integer id) {
		try (var con = dbConfig.getConnection()) {
			var pstmt = con.prepareStatement("SELECT idPelicula, nombrePel, sinopsisPel, categoriaPel, idiomaPel "
					+ "FROM Pelicula WHERE idPelicula = ?");
			pstmt.setInt(1, id);
			var rs = pstmt.executeQuery();
			if (rs.next()) {
				Pelicula pelicula = new Pelicula(rs.getInt("idPelicula"), rs.getString("nombrePel"),
						rs.getString("sinopsisPel"), rs.getString("categoriaPel").charAt(0), rs.getString("idiomaPel"));
				return pelicula;
			}
			return null;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public List<Pelicula> listarTodos() {
		List<Pelicula> ret = new ArrayList<>();
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			var pstmt = con.prepareStatement(
					"SELECT idPelicula, nombrePel, sinopsisPel, categoriaPel, idiomaPel FROM Pelicula ORDER BY idPelicula");
			var rs = pstmt.executeQuery();
			while (rs.next()) {
				Pelicula pelicula = new Pelicula(rs.getInt("idPelicula"), rs.getString("nombrePel"),
						rs.getString("sinopsisPel"), rs.getString("categoriaPel").charAt(0), rs.getString("idiomaPel"));
				ret.add(pelicula);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return ret;
	}

	public void crear(Pelicula pelicula) {
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			var pstmt = con.prepareStatement(
					"INSERT INTO Pelicula (nombrePel, sinopsisPel, categoriaPel, idiomaPel) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, pelicula.getNombrePel());
			pstmt.setString(2, pelicula.getSinopsisPel());
			pstmt.setString(3, String.valueOf(pelicula.getCategoriaPel()));
			pstmt.setString(4, pelicula.getIdiomaPel());
			pstmt.executeUpdate();

			var rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int idPelicula = rs.getInt(1);
				pelicula.setIdPelicula(idPelicula);
			}

			con.commit(); // Commit transaction
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback(); // Rollback transaction on error
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			throw new RuntimeException(ex);
		} finally {
			if (con != null) {
				try {
					con.setAutoCommit(true); // Reset auto-commit to true
					con.close(); // Close connection
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public void actualizar(Pelicula obj) {
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			var pstmt = con.prepareStatement(
					"UPDATE Pelicula SET nombrePel = ?, sinopsisPel = ?, categoriaPel = ?, idiomaPel = ? WHERE idPelicula = ?");
			pstmt.setString(1, obj.getNombrePel());
			pstmt.setString(2, obj.getSinopsisPel());
			pstmt.setString(3, String.valueOf(obj.getCategoriaPel()));
			pstmt.setString(4, obj.getIdiomaPel());
			pstmt.setInt(5, obj.getIdPelicula());
			pstmt.executeUpdate();

			con.commit(); // Commit transaction
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback(); // Rollback transaction on error
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			throw new RuntimeException(ex);
		} finally {
			if (con != null) {
				try {
					con.setAutoCommit(true); // Reset auto-commit to true
					con.close(); // Close connection
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public void eliminarPorId(Integer id) {
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			var pstmt = con.prepareStatement("DELETE FROM Pelicula WHERE idPelicula = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			con.commit(); // Commit transaction
		} catch (Exception ex) {
			if (con != null) {
				try {
					con.rollback(); // Rollback transaction on error
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			throw new RuntimeException(ex);
		} finally {
			if (con != null) {
				try {
					con.setAutoCommit(true); // Reset auto-commit to true
					con.close(); // Close connection
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
