package com.cine.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cine.bean.Empleado;
import com.cine.bean.Persona;
import com.cine.conexionBaseDatos.BaseDatosConexion;
import com.cine.intancias.FactoryImpl;
import com.cine.intancias.TipoPersona;

public class ServiciosEmpleadoImpl implements ServiciosEmpleado {

	private BaseDatosConexion dbConfig;
	FactoryImpl fact = new FactoryImpl();
	Persona persona;

	@Override
	public void setDbConfig(BaseDatosConexion dbConfig) {
		this.dbConfig = dbConfig;
	}

	@Override
	public Persona buscarPorId(Integer id) {
		try (var con = dbConfig.getConnection()) {
			var pstmt = con.prepareStatement(
					"SELECT e.idEmp, e.cargoEmp, e.cuentaBancariaEmp, e.usuarioEmp, e.contraseniaEmp, "
							+ "p.idPer, p.nombrePer, p.cedulaPer, p.correoPer " + "FROM Empleado e "
							+ "JOIN Persona p ON e.idPer = p.idPer " + "WHERE e.idEmp = ?");
			pstmt.setInt(1, id);
			var rs = pstmt.executeQuery();
			if (rs.next()) {
				persona = fact.crearPersona(TipoPersona.EMPLEADO,
						new Empleado.Builder().idEmpleado(rs.getInt("idEmp")).cargoEmpl(rs.getString("cargoEmp"))
								.cuentaBancariaEmpl(rs.getString("cuentaBancariaEmp"))
								.usuarioEmpl(rs.getString("usuarioEmp")).contraseniaEmpl(rs.getString("contraseniaEmp"))
								.idPersona(rs.getInt("idPer")).nombrePer(rs.getString("nombrePer"))
								.cedulaPer(rs.getString("cedulaPer")).correo(rs.getString("correoPer")));
				return persona;
			}
			return null;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<Persona> listarTodos() {
		List<Persona> ret = new ArrayList<>();
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			var pstmt = con.prepareStatement(
					"SELECT e.idEmp, e.cargoEmp, e.cuentaBancariaEmp, e.usuarioEmp, e.contraseniaEmp, "
							+ "p.idPer, p.nombrePer, p.cedulaPer, p.correoPer " + "FROM Empleado e "
							+ "JOIN Persona p ON e.idPer = p.idPer " + "ORDER BY e.idEmp");
			var rs = pstmt.executeQuery();
			while (rs.next()) {
				persona = fact.crearPersona(TipoPersona.EMPLEADO,
						new Empleado.Builder().idEmpleado(rs.getInt("idEmp")).cargoEmpl(rs.getString("cargoEmp"))
								.cuentaBancariaEmpl(rs.getString("cuentaBancariaEmp"))
								.usuarioEmpl(rs.getString("usuarioEmp")).contraseniaEmpl(rs.getString("contraseniaEmp"))
								.idPersona(rs.getInt("idPer")).nombrePer(rs.getString("nombrePer"))
								.cedulaPer(rs.getString("cedulaPer")).correo(rs.getString("correoPer")));
				ret.add(persona);
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
	public void crear(Persona empleado) {
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
			pstmtEmpleado.setString(2, ((Empleado) empleado).getCargoEmpl());
			pstmtEmpleado.setString(3, ((Empleado) empleado).getCuentaBancariaEmpl());
			pstmtEmpleado.setString(4, ((Empleado) empleado).getUsuarioEmpl());
			pstmtEmpleado.setString(5, ((Empleado) empleado).getContraseniaEmpl());
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
	public void actualizar(Persona obj) {
		System.out.println(obj);
		Connection con = null;
		try {
			con = dbConfig.getConnection();
			con.setAutoCommit(false); // Start transaction

			// Update Persona
			var pstmtPersona = con.prepareStatement(
					"UPDATE Persona SET nombrePer = ?, cedulaPer = ?, correoPer = ? WHERE idPer = (SELECT idPer from Empleado where Empleado.idEmp = ?)");
			pstmtPersona.setString(1, obj.getNombrePer());
			pstmtPersona.setString(2, obj.getCedulaPer());
			pstmtPersona.setString(3, obj.getCorreo());
			pstmtPersona.setInt(4, ((Empleado) obj).getIdEmpleado());
			pstmtPersona.executeUpdate();

			// Update Empleado
			var pstmtEmpleado = con.prepareStatement(
					"UPDATE Empleado SET cargoEmp = ?, cuentaBancariaEmp = ?, usuarioEmp = ?, contraseniaEmp = ? WHERE idEmp = ?");
			pstmtEmpleado.setString(1, ((Empleado) obj).getCargoEmpl());
			pstmtEmpleado.setString(2, ((Empleado) obj).getCuentaBancariaEmpl());
			pstmtEmpleado.setString(3, ((Empleado) obj).getUsuarioEmpl());
			pstmtEmpleado.setString(4, ((Empleado) obj).getContraseniaEmpl());
			pstmtEmpleado.setInt(5, ((Empleado) obj).getIdEmpleado());
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
	public void eliminarPorId(int id) {
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
