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

import com.cine.bean.Sala;
import com.cine.conexionBaseDatos.BaseDatosConexion;
import com.cine.servicios.ServicioSalaImpl;

import java.util.List;

public class AddSala extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;
    private JTextField textFieldNombre;
    private JTextField textFieldCapacidadColumna;
    private JTextField textFieldCapacidadFila;
    private JTable table;
    private ServicioSalaImpl servicioSala;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddSala frame = new AddSala();
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
    public AddSala() {
        servicioSala = new ServicioSalaImpl();
        try {
            servicioSala.setDbConfig(BaseDatosConexion.getInstance());
        } catch (SQLException e) {
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

        JLabel lblCapacidadColumna = new JLabel("Capacidad Columna");
        lblCapacidadColumna.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCapacidadColumna.setBounds(28, 68, 150, 13);
        panel.add(lblCapacidadColumna);

        textFieldCapacidadColumna = new JTextField();
        textFieldCapacidadColumna.setColumns(10);
        textFieldCapacidadColumna.setBounds(180, 68, 118, 19);
        panel.add(textFieldCapacidadColumna);

        JLabel lblCapacidadFila = new JLabel("Capacidad Fila");
        lblCapacidadFila.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCapacidadFila.setBounds(28, 92, 150, 13);
        panel.add(lblCapacidadFila);

        textFieldCapacidadFila = new JTextField();
        textFieldCapacidadFila.setColumns(10);
        textFieldCapacidadFila.setBounds(180, 92, 118, 19);
        panel.add(textFieldCapacidadFila);

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
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID", "Nombre", "Capacidad Columna", "Capacidad Fila"
            }
        ));
        scrollPane.setViewportView(table);

        JList list = new JList();
        scrollPane.setColumnHeaderView(list);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(485, 305, 149, 26);
        panel_1.add(btnRegresar);

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminGUI adminFrame = new AdminGUI();
                adminFrame.setVisible(true);
                dispose();
            }
        });

        btnInsertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					agregarSala();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarSala();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarSala();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                textFieldId.setText(table.getValueAt(selectedRow, 0).toString());
                textFieldNombre.setText(table.getValueAt(selectedRow, 1).toString());
                textFieldCapacidadColumna.setText(table.getValueAt(selectedRow, 2).toString());
                textFieldCapacidadFila.setText(table.getValueAt(selectedRow, 3).toString());
            }
        });

        cargarSalas();
    }

    private void cargarSalas() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<Sala> salas = null;
        salas = servicioSala.listarTodos();
        for (Sala sala : salas) {
            model.addRow(new Object[]{sala.getIdSala(), sala.getNombreSala(), sala.getCapacidadColumnaSala(), sala.getCapacidadFilaSala()});
        }
    }

    private void agregarSala() throws SQLException {
        String nombre = textFieldNombre.getText();
        int capacidadColumna = Integer.parseInt(textFieldCapacidadColumna.getText());
        int capacidadFila = Integer.parseInt(textFieldCapacidadFila.getText());

        Sala sala = new Sala(0, nombre, capacidadColumna, capacidadFila);

        servicioSala.crear(sala);
        cargarSalas();
        limpiarCampos();
    }

    private void actualizarSala() {
        int id = Integer.parseInt(textFieldId.getText());
        String nombre = textFieldNombre.getText();
        int capacidadColumna = Integer.parseInt(textFieldCapacidadColumna.getText());
        int capacidadFila = Integer.parseInt(textFieldCapacidadFila.getText());

        Sala sala = new Sala(id, nombre, capacidadColumna, capacidadFila);

        servicioSala.actualizar(sala);
        cargarSalas();
        limpiarCampos();
    }

    private void eliminarSala() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una sala para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = (int) table.getValueAt(selectedRow, 0);
        servicioSala.eliminarPorId(id);
        cargarSalas();
        limpiarCampos();
    }

    private void limpiarCampos() {
        textFieldId.setText("");
        textFieldNombre.setText("");
        textFieldCapacidadColumna.setText("");
        textFieldCapacidadFila.setText("");
    }
}
