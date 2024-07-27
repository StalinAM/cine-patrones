package com.manager.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cine.conexionBaseDatos.BaseDatosConexion;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 590, 340);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(21, 11, 532, 267);
        contentPane.add(panel);
        panel.setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(191, 100, 265, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("CINE-CENTRAL");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 22, 532, 49);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Usuario:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(83, 100, 83, 17);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Contraseña:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(83, 150, 98, 14);
        panel.add(lblNewLabel_2);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setBounds(191, 150, 265, 20);
        panel.add(passwordField);
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarUsuario();
            }
        });
        btnNewButton.setBounds(191, 196, 115, 23);
        panel.add(btnNewButton);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnCancelar.setBounds(341, 196, 115, 23);
        panel.add(btnCancelar);
    }

    private void validarUsuario() {
        String usuario = textField.getText();
        String contraseña = new String(passwordField.getPassword());

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = BaseDatosConexion.getInstance().getConnection();
            String sql = "SELECT cargoEmp FROM Empleado WHERE usuarioEmp = ? AND contraseniaEmp = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, contraseña);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String cargo = resultSet.getString("cargoEmp");

                if (cargo.equals("administrador")) {
                    AdminGUI adminGUI = new AdminGUI();
                    adminGUI.setVisible(true);
                } else if (cargo.equals("vendedor")) {
                    MostrarPeliculas mostrarPeliculas = new MostrarPeliculas();
                    mostrarPeliculas.setVisible(true);
                }

                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
