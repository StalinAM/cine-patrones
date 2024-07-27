package com.cine.servicios;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cine.bean.Sala;
import com.cine.bean.Sala.Builder;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public class ServicioSalaImpl implements ServicioSala {

	private BaseDatosConexion dbConfig;

	@Override
	public void setDbConfig(BaseDatosConexion dbConfig) {
		this.dbConfig = dbConfig;
	}

	@Override
	public Sala buscarPorId(Integer id){
		try (var con = dbConfig.getConnection()) {
			var pstmt = con.prepareStatement(
					"SELECT idSala, nombreSala, capacidadColumnaSala, capacidadFilaSala FROM Sala WHERE idSala = ?");
			pstmt.setInt(1, id);
			var rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Sala.Builder().idSala(rs.getInt("idSala")).nombreSala(rs.getString("nombreSala"))
						.capacidadColumnaSala(rs.getInt("capacidadColumnaSala"))
						.capacidadFilaSala(rs.getInt("capacidadFilaSala")).build();
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	@Override
	public List<Sala> listarTodos() {
		List<Sala> salas = new ArrayList<>();
		try (var con = dbConfig.getConnection()) {
			var pstmt = con
					.prepareStatement("SELECT idSala, nombreSala, capacidadColumnaSala, capacidadFilaSala FROM Sala");
			var rs = pstmt.executeQuery();
			while (rs.next()) {
				Sala sala = new Sala.Builder().idSala(rs.getInt("idSala")).nombreSala(rs.getString("nombreSala"))
						.capacidadColumnaSala(rs.getInt("capacidadColumnaSala"))
						.capacidadFilaSala(rs.getInt("capacidadFilaSala")).build();
				salas.add(sala);
			}
		} catch (Exception ex) {
			  System.out.println(ex);
		}
		return salas;
	}

	@Override
	public void crear(Object sala) {
		try (var con = dbConfig.getConnection()) {
			con.setAutoCommit(false);
			var pstmt = con.prepareStatement(
					"INSERT INTO Sala (nombreSala, capacidadColumnaSala, capacidadFilaSala) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, ((Builder) sala).build().getNombreSala());
			pstmt.setInt(2, ((Builder) sala).build().getCapacidadColumnaSala());
			pstmt.setInt(3, ((Builder) sala).build().getCapacidadFilaSala());
			pstmt.executeUpdate();
			var rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				((Builder) sala).idSala(rs.getInt(1));
			}
			con.commit();
		} catch (Exception ex) {

			System.out.println(ex);
		}
	}

	@Override
	public void actualizar(Sala sala) {
		try (var con = dbConfig.getConnection()) {
			con.setAutoCommit(false);
			var pstmt = con.prepareStatement(
					"UPDATE Sala SET nombreSala = ?, capacidadColumnaSala = ?, capacidadFilaSala = ? WHERE idSala = ?");
			pstmt.setString(1, sala.getNombreSala());
			pstmt.setInt(2, sala.getCapacidadColumnaSala());
			pstmt.setInt(3, sala.getCapacidadFilaSala());
			pstmt.setInt(4, sala.getIdSala());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void eliminarPorId(Integer id) {
		try (var con = dbConfig.getConnection()) {
			con.setAutoCommit(false);
			var pstmt = con.prepareStatement("DELETE FROM Sala WHERE idSala = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
