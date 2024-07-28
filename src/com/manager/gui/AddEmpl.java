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

import com.cine.bean.Empleado;
import com.cine.bean.Persona;
import com.cine.conexionBaseDatos.BaseDatosConexion;
import com.cine.intancias.FactoryImpl;
import com.cine.intancias.TipoPersona;
import com.cine.servicios.ServiciosEmpleadoImpl;

import java.util.List;

public class AddEmpl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldCedula;
	private JTextField textFieldCorreo;
	private JTextField textFieldCargo;
	private JTextField textFieldCuentaBancaria;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenia;
	private JTable table;
	private ServiciosEmpleadoImpl serviciosEmpleado;
	FactoryImpl fact = new FactoryImpl();
	Persona persona = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmpl frame = new AddEmpl();
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
	public AddEmpl() {
		serviciosEmpleado = new ServiciosEmpleadoImpl();
		try {
			serviciosEmpleado.setDbConfig(BaseDatosConexion.getInstance());
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
		btnInsertar.setBounds(10, 262, 149, 26);
		panel.add(btnInsertar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(173, 262, 149, 26);
		panel.add(btnActualizar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 302, 149, 26);
		panel.add(btnEliminar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(173, 302, 149, 26);
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

		JLabel lblCedula = new JLabel("Cédula");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCedula.setBounds(28, 68, 65, 13);
		panel.add(lblCedula);

		textFieldCedula = new JTextField();
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(180, 68, 118, 19);
		panel.add(textFieldCedula);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo.setBounds(28, 92, 65, 13);
		panel.add(lblCorreo);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(180, 92, 118, 19);
		panel.add(textFieldCorreo);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCargo.setBounds(28, 116, 65, 19);
		panel.add(lblCargo);

		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(180, 116, 118, 19);
		panel.add(textFieldCargo);

		JLabel lblCuentaBancaria = new JLabel("Cuenta Bancaria");
		lblCuentaBancaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuentaBancaria.setBounds(28, 140, 150, 13);
		panel.add(lblCuentaBancaria);

		textFieldCuentaBancaria = new JTextField();
		textFieldCuentaBancaria.setColumns(10);
		textFieldCuentaBancaria.setBounds(180, 140, 118, 19);
		panel.add(textFieldCuentaBancaria);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(28, 164, 65, 13);
		panel.add(lblUsuario);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(180, 164, 118, 19);
		panel.add(textFieldUsuario);

		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasenia.setBounds(28, 188, 150, 13);
		panel.add(lblContrasenia);

		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setColumns(10);
		textFieldContrasenia.setBounds(180, 188, 118, 19);
		panel.add(textFieldContrasenia);

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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nombre", "Cédula", "Correo",
				"Cargo", "Cuenta Bancaria", "Usuario", "Contraseña" }));
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
				agregarEmpleado();
			}
		});

		// Añadir ActionListener al botón "Actualizar"
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarEmpleado();
			}
		});

		// Añadir ActionListener al botón "Eliminar"
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarEmpleado();
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
				textFieldCedula.setText(table.getValueAt(selectedRow, 2).toString());
				textFieldCorreo.setText(table.getValueAt(selectedRow, 3).toString());
				textFieldCargo.setText(table.getValueAt(selectedRow, 4).toString());
				textFieldCuentaBancaria.setText(table.getValueAt(selectedRow, 5).toString());
				textFieldUsuario.setText(table.getValueAt(selectedRow, 6).toString());
				textFieldContrasenia.setText(table.getValueAt(selectedRow, 7).toString());
			}
		});

		cargarEmpleados();
	}

	private void cargarEmpleados() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<Persona> empleados = serviciosEmpleado.listarTodos();
		for (Persona empleado : empleados) {
			model.addRow(new Object[] { ((Empleado) empleado).getIdEmpleado(), empleado.getNombrePer(),
					empleado.getCedulaPer(), empleado.getCorreo(), ((Empleado) empleado).getCargoEmpl(),
					((Empleado) empleado).getCuentaBancariaEmpl(), ((Empleado) empleado).getUsuarioEmpl(),
					((Empleado) empleado).getContraseniaEmpl() });
		}
	}

	private void agregarEmpleado() {
		String nombre = textFieldNombre.getText();
		String cedula = textFieldCedula.getText();
		String correo = textFieldCorreo.getText();
		String cargo = textFieldCargo.getText();
		String cuentaBancaria = textFieldCuentaBancaria.getText();
		String usuario = textFieldUsuario.getText();
		String contrasenia = textFieldContrasenia.getText();

		persona = fact.crearPersona(TipoPersona.EMPLEADO,
				new Empleado.Builder().nombrePer(nombre).cedulaPer(cedula).correo(correo).cargoEmpl(cargo)
						.cuentaBancariaEmpl(cuentaBancaria).usuarioEmpl(usuario).contraseniaEmpl(contrasenia));

		serviciosEmpleado.crear(persona);
		cargarEmpleados();
		limpiarCampos();
	}

	private void actualizarEmpleado() {
		int id = Integer.parseInt(textFieldId.getText());
		String nombre = textFieldNombre.getText();
		String cedula = textFieldCedula.getText();
		String correo = textFieldCorreo.getText();
		String cargo = textFieldCargo.getText();
		String cuentaBancaria = textFieldCuentaBancaria.getText();
		String usuario = textFieldUsuario.getText();
		String contrasenia = textFieldContrasenia.getText();

		persona = fact.crearPersona(TipoPersona.EMPLEADO,
				new Empleado.Builder().idEmpleado(id).nombrePer(nombre).cedulaPer(cedula).correo(correo)
						.cargoEmpl(cargo).cuentaBancariaEmpl(cuentaBancaria).usuarioEmpl(usuario)
						.contraseniaEmpl(contrasenia));

		serviciosEmpleado.actualizar(persona);
		cargarEmpleados();
		limpiarCampos();
	}

	private void eliminarEmpleado() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona un empleado para eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id = (int) table.getValueAt(selectedRow, 0);
		serviciosEmpleado.eliminarPorId(id);
		cargarEmpleados();
		limpiarCampos();
	}

	private void limpiarCampos() {
		textFieldId.setText("");
		textFieldNombre.setText("");
		textFieldCedula.setText("");
		textFieldCorreo.setText("");
		textFieldCargo.setText("");
		textFieldCuentaBancaria.setText("");
		textFieldUsuario.setText("");
		textFieldContrasenia.setText("");
	}
}
