package com.manager.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cine.bean.Pelicula;
import com.cine.conexionBaseDatos.BaseDatosConexion;
import com.cine.servicios.ServiciosPeliculasImpl;

import java.util.List;

public class AddPeli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldSinopsis;
	private JTextField textFieldCategoria;
	private JTextField textFieldIdioma;
	private JTable table;
	private ServiciosPeliculasImpl serviciosPeliculas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPeli frame = new AddPeli();
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
	public AddPeli() {
		serviciosPeliculas = new ServiciosPeliculasImpl();
		try {
			serviciosPeliculas.setDbConfig(BaseDatosConexion.getInstance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(21, 21, 332, 353);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(10, 218, 149, 26);
		panel.add(btnInsertar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(173, 218, 149, 26);
		panel.add(btnActualizar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 250, 149, 26);
		panel.add(btnEliminar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(173, 250, 149, 26);
		panel.add(btnLimpiar);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(28, 20, 45, 13);
		panel.add(lblId);

		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(180, 20, 118, 19);
		textFieldId.setEditable(false);
		panel.add(textFieldId);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(28, 44, 65, 13);
		panel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(180, 44, 118, 19);
		panel.add(textFieldNombre);

		JLabel lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinopsis.setBounds(28, 68, 65, 13);
		panel.add(lblSinopsis);

		textFieldSinopsis = new JTextField();
		textFieldSinopsis.setColumns(10);
		textFieldSinopsis.setBounds(180, 68, 118, 19);
		panel.add(textFieldSinopsis);

		JLabel lblCategoria = new JLabel("Categoría");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(28, 92, 65, 13);
		panel.add(lblCategoria);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setColumns(10);
		textFieldCategoria.setBounds(180, 92, 118, 19);
		panel.add(textFieldCategoria);

		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdioma.setBounds(28, 116, 65, 13);
		panel.add(lblIdioma);

		textFieldIdioma = new JTextField();
		textFieldIdioma.setColumns(10);
		textFieldIdioma.setBounds(180, 116, 118, 19);
		panel.add(textFieldIdioma);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(384, 21, 660, 353);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JTextField textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(102, 19, 432, 19);
		panel_1.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		JLabel lblBuscador = new JLabel("Buscador");
		lblBuscador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscador.setBounds(31, 25, 93, 13);
		panel_1.add(lblBuscador);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 68, 603, 211);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nombre", "Sinopsis", "Categoría", "Idioma" }));
		scrollPane.setViewportView(table);

		JList list = new JList();
		scrollPane.setColumnHeaderView(list);

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(485, 305, 149, 26);
		panel_1.add(btnRegresar);

		// Añadir ActionListener al botón "Regresar"
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGUI adminFrame = new AdminGUI();
				adminFrame.setVisible(true);
				dispose();
			}
		});

		// Añadir ActionListener al botón "Insertar"
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPelicula();
			}
		});

		// Añadir ActionListener al botón "Actualizar"
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarPelicula();
			}
		});

		// Añadir ActionListener al botón "Eliminar"
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPelicula();
			}
		});

		// Añadir ActionListener al botón "Limpiar"
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});

		// Añadir MouseListener a la tabla para autocompletar campos al seleccionar una
		// fila
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				textFieldId.setText(table.getValueAt(selectedRow, 0).toString());
				textFieldNombre.setText(table.getValueAt(selectedRow, 1).toString());
				textFieldSinopsis.setText(table.getValueAt(selectedRow, 2).toString());
				textFieldCategoria.setText(table.getValueAt(selectedRow, 3).toString());
				textFieldIdioma.setText(table.getValueAt(selectedRow, 4).toString());
			}
		});

		cargarPeliculas();
	}

	private void cargarPeliculas() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<Pelicula> peliculas = serviciosPeliculas.listarTodos();
		for (Pelicula pelicula : peliculas) {
			model.addRow(new Object[] { pelicula.getIdPelicula(), pelicula.getNombrePel(), pelicula.getSinopsisPel(),
					pelicula.getCategoriaPel(), pelicula.getIdiomaPel() });
		}
	}

	private void agregarPelicula() {
		String nombre = textFieldNombre.getText();
		String sinopsis = textFieldSinopsis.getText();
		char categoria = textFieldCategoria.getText().charAt(0);
		String idioma = textFieldIdioma.getText();

		Pelicula pelicula = new Pelicula(0, nombre, sinopsis, categoria, idioma);

		serviciosPeliculas.crear(pelicula);
		cargarPeliculas();
		limpiarCampos();
	}

	private void actualizarPelicula() {
		int id = Integer.parseInt(textFieldId.getText());
		String nombre = textFieldNombre.getText();
		String sinopsis = textFieldSinopsis.getText();
		char categoria = textFieldCategoria.getText().charAt(0);
		String idioma = textFieldIdioma.getText();

		Pelicula pelicula = new Pelicula(id, nombre, sinopsis, categoria, idioma);

		serviciosPeliculas.actualizar(pelicula);
		cargarPeliculas();
		limpiarCampos();
	}

	private void eliminarPelicula() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona una película para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id = (int) table.getValueAt(selectedRow, 0);
		serviciosPeliculas.eliminarPorId(id);
		cargarPeliculas();
		limpiarCampos();
	}

	private void limpiarCampos() {
		textFieldId.setText("");
		textFieldNombre.setText("");
		textFieldSinopsis.setText("");
		textFieldCategoria.setText("");
		textFieldIdioma.setText("");
	}
}
