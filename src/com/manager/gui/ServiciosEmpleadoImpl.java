package com.manager.gui;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cine.bean.Empleado;
import com.cine.bean.Empleado.Builder;
import com.cine.conexionBaseDatos.BaseDatosConexion;
import com.cine.servicios.ServiciosEmpleado;

public class ServiciosEmpleadoImpl implements ServiciosEmpleado {

	private BaseDatosConexion dbConfig;

	@Override
	public void setDbConfig(BaseDatosConexion dbConfig) {
		this.dbConfig = dbConfig;
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		try (var con = dbConfig.getConnection()) {
			var pstmt = con.prepareStatement(
					"SELECT e.idEmp, e.cargoEmp, e.cuentaBancariaEmp, e.usuarioEmp, e.contraseniaEmp, "
							+ "p.idPer, p.nombrePer, p.cedulaPer, p.correoPer " + "FROM Empleado e "
							+ "JOIN Persona p ON e.idPer = p.idPer " + "WHERE e.idEmp = ?");
			pstmt.setInt(1, id);
			var rs = pstmt.executeQuery();
			if (rs.next()) {
				Empleado empleado = new Empleado.Builder().idEmpleado(rs.getInt("idEmp"))
						.cargoEmpl(rs.getString("cargoEmp")).cuentaBancariaEmpl(rs.getString("cuentaBancariaEmp"))
						.usuarioEmpl(rs.getString("usuarioEmp")).contraseniaEmpl(rs.getString("contraseniaEmp"))
						.idPersona(rs.getInt("idPer")).nombrePer(rs.getString("nombrePer"))
						.cedulaPer(rs.getString("cedulaPer")).correo(rs.getString("correoPer")).build();
				return empleado;
			}
			return null;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<Empleado> listarTodos() {
		List<Empleado> ret = new ArrayList<>();
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			var pstmt = con.prepareStatement(
					"SELECT e.idEmp, e.cargoEmp, e.cuentaBancariaEmp, e.usuarioEmp, e.contraseniaEmp, "
							+ "p.idPer, p.nombrePer, p.cedulaPer, p.correoPer " + "FROM Empleado e "
							+ "JOIN Persona p ON e.idPer = p.idPer " + "ORDER BY e.idEmp");
			var rs = pstmt.executeQuery();
			while (rs.next()) {
				Empleado empleado = new Empleado.Builder().idEmpleado(rs.getInt("idEmp"))
						.cargoEmpl(rs.getString("cargoEmp")).cuentaBancariaEmpl(rs.getString("cuentaBancariaEmp"))
						.usuarioEmpl(rs.getString("usuarioEmp")).contraseniaEmpl(rs.getString("contraseniaEmp"))
						.idPersona(rs.getInt("idPer")).nombrePer(rs.getString("nombrePer"))
						.cedulaPer(rs.getString("cedulaPer")).correo(rs.getString("correoPer")).build();
				ret.add(empleado);
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
	public void crear(Empleado empleado) {
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			// Insert into Persona
			var pstmtPersona = con.prepareStatement(
					"INSERT INTO Persona (nombrePer, cedulaPer, correoPer) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmtPersona.setString(1, empleado.getNombrePer());
			pstmtPersona.setString(2, empleado.getCedulaPer());
			pstmtPersona.setString(3, empleado.getCorreo());
			pstmtPersona.executeUpdate();

			// Get generated idPer
			var rs = pstmtPersona.getGeneratedKeys();
			int idPer = 0;
			if (rs.next()) {
				idPer = rs.getInt(1);// Set the generated idPer in Empleado object
			}

			// Insert into Empleado
			var pstmtEmpleado = con.prepareStatement(
					"INSERT INTO Empleado (idPer, cargoEmp, cuentaBancariaEmp, usuarioEmp, contraseniaEmp) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmtEmpleado.setInt(1, idPer);
			pstmtEmpleado.setString(2, empleado.getCargoEmpl());
			pstmtEmpleado.setString(3, empleado.getCuentaBancariaEmpl());
			pstmtEmpleado.setString(4, empleado.getUsuarioEmpl());
			pstmtEmpleado.setString(5, empleado.getContraseniaEmpl());
			pstmtEmpleado.executeUpdate();

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
	public void actualizar(Empleado obj) {
		System.out.println(obj);
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			// Update Persona
			var pstmtPersona = con
					.prepareStatement("UPDATE Persona SET nombrePer = ?, cedulaPer = ?, correoPer = ? WHERE idPer = (SELECT idPer from Empleado where Empleado.idEmp = ?)");
			pstmtPersona.setString(1, obj.getNombrePer());
			pstmtPersona.setString(2, obj.getCedulaPer());
			pstmtPersona.setString(3, obj.getCorreo());
			pstmtPersona.setInt(4, obj.getIdEmpleado());
			pstmtPersona.executeUpdate();

			// Update Empleado
			var pstmtEmpleado = con.prepareStatement(
					"UPDATE Empleado SET cargoEmp = ?, cuentaBancariaEmp = ?, usuarioEmp = ?, contraseniaEmp = ? WHERE idEmp = ?");
			pstmtEmpleado.setString(1, obj.getCargoEmpl());
			pstmtEmpleado.setString(2, obj.getCuentaBancariaEmpl());
			pstmtEmpleado.setString(3, obj.getUsuarioEmpl());
			pstmtEmpleado.setString(4, obj.getContraseniaEmpl());
			pstmtEmpleado.setInt(5, obj.getIdEmpleado());
			pstmtEmpleado.executeUpdate();

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

			// Get idPer from Empleado
			var pstmtGetIdPer = con.prepareStatement("SELECT idPer FROM Empleado WHERE idEmp = ?");
			pstmtGetIdPer.setInt(1, id);
			var rs = pstmtGetIdPer.executeQuery();
			int idPer = 0;
			if (rs.next()) {
				idPer = rs.getInt("idPer");
			}

			// Delete from Empleado
			var pstmtDeleteEmpleado = con.prepareStatement("DELETE FROM Empleado WHERE idEmp = ?");
			pstmtDeleteEmpleado.setInt(1, id);
			pstmtDeleteEmpleado.executeUpdate();

			// Delete from Persona if idPer is not null

			var pstmtDeletePersona = con.prepareStatement("DELETE FROM Persona WHERE idPer = ?");
			pstmtDeletePersona.setInt(1, idPer);
			pstmtDeletePersona.executeUpdate();

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
