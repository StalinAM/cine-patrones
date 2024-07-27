package com.cine.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cine.bean.*;
import com.cine.conexionBaseDatos.BaseDatosConexion;

public class ServiciosClienteImpl implements ServiciosCliente {

	private BaseDatosConexion dbConfig;

	@Override
	public void setDbConfig(BaseDatosConexion dbConfig) {
		this.dbConfig = dbConfig;
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		try (var con = dbConfig.getConnection()) {
			var pstmt = con.prepareStatement(
					"SELECT c.idCli, c.direccionCli, c.telefonoCli, p.idPer, p.nombrePer, p.cedulaPer, p.correoPer "
							+ "FROM Cliente c " + "JOIN Persona p ON c.idPer = p.idPer " + "WHERE c.idCli = ?");
			pstmt.setInt(1, id);
			var rs = pstmt.executeQuery();
			if (rs.next()) {
				Cliente cliente = new Cliente.Builder().idCliente(rs.getInt("idCli"))
						.direccionCli(rs.getString("direccionCli")).telefonoCli(rs.getString("telefonoCli"))
						.idPersona(rs.getInt("idPer")).nombrePer(rs.getString("nombrePer"))
						.cedulaPer(rs.getString("cedulaPer")).correo(rs.getString("correoPer")).build();
				return cliente;
			}
			return null;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<Cliente> listarTodos() {
		List<Cliente> ret = new ArrayList<>();
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			var pstmt = con.prepareStatement(
					"SELECT c.idCli, c.direccionCli, c.telefonoCli, p.idPer, p.nombrePer, p.cedulaPer, p.correoPer "
							+ "FROM Cliente c " + "JOIN Persona p ON c.idPer = p.idPer " + "ORDER BY c.idCli");
			var rs = pstmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente.Builder().idCliente(rs.getInt("idCli"))
						.direccionCli(rs.getString("direccionCli")).telefonoCli(rs.getString("telefonoCli"))
						.idPersona(rs.getInt("idPer")).nombrePer(rs.getString("nombrePer"))
						.cedulaPer(rs.getString("cedulaPer")).correo(rs.getString("correoPer")).build();
				ret.add(cliente);
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

	@Override
	public void crear(Cliente obj) {
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			// Insert into Persona
			var pstmtPersona = con.prepareStatement(
					"INSERT INTO Persona (nombrePer, cedulaPer, correoPer) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmtPersona.setString(1, obj.getNombrePer());
			pstmtPersona.setString(2, obj.getCedulaPer());
			pstmtPersona.setString(3, obj.getCorreo());
			pstmtPersona.executeUpdate();

			// Get generated idPer
			var rs = pstmtPersona.getGeneratedKeys();
			int idPer = 0;
			if (rs.next()) {
				idPer = rs.getInt(1);
			}

			// Insert into Cliente
			var pstmtCliente = con
					.prepareStatement("INSERT INTO Cliente (idPer, direccionCli, telefonoCli) VALUES (?, ?, ?)");
			pstmtCliente.setInt(1, idPer);
			pstmtCliente.setString(2, obj.getDireccionCli());
			pstmtCliente.setString(3, obj.getTelefonoCli());
			pstmtCliente.executeUpdate();

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

	@Override
	public void actualizar(Cliente obj) {
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			// Update Persona
			var pstmtPersona = con
					.prepareStatement("UPDATE Persona SET nombrePer = ?, cedulaPer = ?, correoPer = ? WHERE idPer = ?");
			pstmtPersona.setString(1, obj.getNombrePer());
			pstmtPersona.setString(2, obj.getCedulaPer());
			pstmtPersona.setString(3, obj.getCorreo());
			pstmtPersona.setInt(4, obj.getIdPersona());
			pstmtPersona.executeUpdate();

			// Update Cliente
			var pstmtCliente = con
					.prepareStatement("UPDATE Cliente SET direccionCli = ?, telefonoCli = ? WHERE idCli = ?");
			pstmtCliente.setString(1, obj.getDireccionCli());
			pstmtCliente.setString(2, obj.getTelefonoCli());
			pstmtCliente.setInt(3, obj.getIdCliente());
			pstmtCliente.executeUpdate();

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

	@Override
	public void eliminarPorId(Integer id) {
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			// Get idPer from Cliente
			var pstmtGetIdPer = con.prepareStatement("SELECT idPer FROM Cliente WHERE idCli = ?");
			pstmtGetIdPer.setInt(1, id);
			var rs = pstmtGetIdPer.executeQuery();
			Integer idPer = null;
			if (rs.next()) {
				idPer = rs.getInt("idPer");
			}

			// Delete from VentaBoleto where idCli is the client id
			var pstmtDeleteVentaBoleto = con.prepareStatement("DELETE FROM VentaBoleto WHERE idCli = ?");
			pstmtDeleteVentaBoleto.setInt(1, id);
			pstmtDeleteVentaBoleto.executeUpdate();

			// Delete from Cliente
			var pstmtDeleteCliente = con.prepareStatement("DELETE FROM Cliente WHERE idCli = ?");
			pstmtDeleteCliente.setInt(1, id);
			pstmtDeleteCliente.executeUpdate();

			// Delete from Persona if idPer is not null
			if (idPer != null) {
				var pstmtDeletePersona = con.prepareStatement("DELETE FROM Persona WHERE idPer = ?");
				pstmtDeletePersona.setInt(1, idPer);
				pstmtDeletePersona.executeUpdate();
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

}
