package com.cine.conexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatosConexion {
    private static BaseDatosConexion instance;
    private String url = "jdbc:mysql://localhost:3306/cine";
    private String username = "root";
    private String password = "root";

    private BaseDatosConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static BaseDatosConexion getInstance() throws SQLException {
        if (instance == null) {
            synchronized (BaseDatosConexion.class) {
                if (instance == null) {
                    instance = new BaseDatosConexion();
                }
            }
        }
        return instance;
    }
}
