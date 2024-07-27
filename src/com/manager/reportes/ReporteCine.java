package com.manager.reportes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

import com.manager.gui.AdminGUI;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteCine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteCine frame = new ReporteCine();
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
	public ReporteCine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECCION REPORTE DE VENTAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(47, 11, 542, 87);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(47, 90, 87, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Desde:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(67, 138, 87, 59);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hasta:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1_1.setBounds(67, 178, 87, 43);
		contentPane.add(lblNewLabel_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(164, 159, 126, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(164, 188, 126, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Película:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(47, 236, 100, 59);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 260, 30, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Sala:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_1.setBounds(47, 293, 100, 59);
		contentPane.add(lblNewLabel_1_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(164, 317, 30, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tipo de reporte:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_2.setBounds(47, 350, 192, 59);
		contentPane.add(lblNewLabel_1_2_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox_2.setBounds(249, 374, 30, 22);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaReporte tb = new TablaReporte();
				tb.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(55, 431, 108, 37);
		contentPane.add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnRegresar.setBounds(455, 431, 134, 37);
		contentPane.add(btnRegresar);

		// Añadir ActionListener al botón "Regresar"
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crear y mostrar la interfaz AdminGUI
				AdminGUI adminFrame = new AdminGUI();
				adminFrame.setVisible(true);
				// Cerrar la interfaz ReporteCine
				dispose();
			}
		});
	}
}
