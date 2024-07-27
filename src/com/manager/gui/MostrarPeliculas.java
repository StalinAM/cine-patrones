package com.manager.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class MostrarPeliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarPeliculas frame = new MostrarPeliculas();
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
	public MostrarPeliculas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pelicula_titulo = new JPanel();
		pelicula_titulo.setLayout(null);
		pelicula_titulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pelicula_titulo.setBackground(new Color(62, 62, 62));
		pelicula_titulo.setBounds(0, 0, 1264, 53);
		contentPane.add(pelicula_titulo);
		
		JLabel lblNewLabel_1 = new JLabel("CARTELERA");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel_1.setBounds(10, 0, 1150, 50);
		pelicula_titulo.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 64, 463, 580);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Película");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(60, 77, 83, 17);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(153, 75, 265, 20);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(153, 100, 265, 22);
		panel.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Español", "Ingles"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(153, 269, 265, 22);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2D", "3D", "4D"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(153, 335, 265, 22);
		panel.add(comboBox_1_1);
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"09:00 - 11:00", "13:00 - 15:00", "17:00 - 19:00", "21:00 - 23:00"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Idioma:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(60, 103, 83, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sala:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(60, 272, 83, 17);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Fecha:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(60, 305, 83, 17);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Hora:");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_3_1.setBounds(60, 338, 83, 17);
		panel.add(lblNewLabel_1_1_3_1);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"10/07/2024", "10/07/2024", "10/07/2024", "10/07/2024", "10/07/2024", "10/07/2024", "10/07/2024", "10/07/2024"}));
		comboBox_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1_2.setBounds(153, 302, 265, 22);
		panel.add(comboBox_1_2);
		
		JButton btnAsientos = new JButton("Asientos");
		btnAsientos.setBounds(303, 450, 115, 23);
		panel.add(btnAsientos);
		btnAsientos.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Sinópsis");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_2_1.setBounds(60, 131, 83, 17);
		panel.add(lblNewLabel_1_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 133, 265, 91);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Categoría:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_4.setBounds(60, 237, 83, 17);
		panel.add(lblNewLabel_1_1_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(153, 235, 265, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("ID");
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_5.setBounds(60, 45, 83, 17);
		panel.add(lblNewLabel_1_1_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(153, 43, 265, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Asiento Disponibles:");
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_6.setBounds(60, 370, 149, 17);
		panel.add(lblNewLabel_1_1_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(203, 368, 215, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_1_7 = new JLabel("Precio:");
		lblNewLabel_1_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7.setBounds(60, 400, 83, 17);
		panel.add(lblNewLabel_1_1_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(153, 398, 265, 20);
		panel.add(textField_5);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCerrarSesin.setBounds(269, 484, 149, 23);
		panel.add(btnCerrarSesin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(483, 64, 771, 580);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 11, 703, 558);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Categor\u00EDa", "Idioma"
			}
		));
		scrollPane.setViewportView(table);
		
		btnAsientos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        AsientosSala asientosSala = new AsientosSala();
		        asientosSala.setVisible(true);
		    }
		});
		
	}
}
