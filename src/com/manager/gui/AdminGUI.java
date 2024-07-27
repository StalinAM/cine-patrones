package com.manager.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.manager.reportes.ReporteCine;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGUI extends JFrame {
    public AdminGUI() {
        // Configuración del JFrame
        setTitle("Administrador CINMAX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        getContentPane().setLayout(null);
        setResizable(false); // Hacer la ventana no redimensionable

        // Crear y agregar una etiqueta
        JLabel lblTitle = new JLabel("ADMINISTRADOR CINMAX");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(10, 10, 364, 14);
        getContentPane().add(lblTitle);

        // Crear y agregar botones
        JButton btnAddSalas = new JButton("Salas");
        btnAddSalas.setBounds(50, 50, 150, 50); // Aumentar el ancho del botón
        getContentPane().add(btnAddSalas);

        JButton btnAddMovies = new JButton("Películas");
        btnAddMovies.setBounds(200, 50, 150, 50); // Aumentar el ancho del botón
        getContentPane().add(btnAddMovies);

        JButton btnSellers = new JButton("Empleados");
        btnSellers.setBounds(50, 111, 150, 50); // Ajustar el ancho del botón
        getContentPane().add(btnSellers);

        JButton btnClients = new JButton("Reportes");
        btnClients.setBounds(200, 111, 150, 50); // Ajustar el ancho del botón
        getContentPane().add(btnClients);
        
        JButton btnCerrarSesin = new JButton("Cerrar Sesión");
        btnCerrarSesin.setBounds(123, 172, 150, 50);
        getContentPane().add(btnCerrarSesin);
        
        // Añadir ActionListener al botón "Añadir Salas"
        btnAddSalas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar la interfaz AddPeli
                AddSala addSalaFrame = new AddSala();
                addSalaFrame.setVisible(true);
            }
        });

        // Añadir ActionListener al botón "Añadir Películas"
        btnAddMovies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar la interfaz AddPeli
                AddPeli addPeliFrame = new AddPeli();
                addPeliFrame.setVisible(true);
            }
        });

        // Añadir ActionListener al botón "Empleados"
        btnSellers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar la interfaz AddEmpl
                AddEmpl addEmplFrame = new AddEmpl();
                addEmplFrame.setVisible(true);
            }
        });

        // Añadir ActionListener al botón "Reportes"
        btnClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar la interfaz ReporteCine
                ReporteCine reporteCineFrame = new ReporteCine();
                reporteCineFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        AdminGUI frame = new AdminGUI();
        frame.setVisible(true);
    }
}
