package com.manager.gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class AsientosSala extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int asientosSeleccionados = 0;
    private JLabel lblAsientos, lblPelicula, lblSala, lblTotal;
    private static final int PRECIO_POR_ASIENTO = 20;
    private JTextField txtReservados;
    private JTextField txtDisponibles;
    private JTextField txtSuAsiento;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AsientosSala frame = new AsientosSala();
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
    public AsientosSala() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(72, 72, 72));
        contentPane.setBorder(new EmptyBorder(51, 51, 51, 51));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear panel para el rectángulo superior
        JPanel panelPantalla = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelPantalla.setBounds(0, 0, 808, 50);
        contentPane.add(panelPantalla);
        panelPantalla.setLayout(null);

        // Añadir etiqueta de "PANTALLA" al panel
        JLabel lblPantalla = new JLabel("PANTALLA");
        lblPantalla.setBounds(0, 0, 808, 50);
        panelPantalla.add(lblPantalla);
        lblPantalla.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblPantalla.setHorizontalAlignment(SwingConstants.CENTER);

        int buttonWidth = 50;
        int buttonHeight = 50;
        int startX = 50;
        int startY = 100; // Ajustar para dejar espacio para el rectángulo superior
        int spaceX = 10;
        int spaceY = 10;

        // Panel derecho para la información
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(new Color(72, 72, 72));
        panelInfo.setBounds(850, 100, 400, 500);
        contentPane.add(panelInfo);
        panelInfo.setLayout(null);

        // Añadir etiquetas al panel de información
        lblAsientos = new JLabel("Asientos: 0 de 3");
        lblAsientos.setForeground(new Color(255, 255, 255));
        lblAsientos.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblAsientos.setBounds(10, 10, 380, 40);
        panelInfo.add(lblAsientos);

        lblPelicula = new JLabel("Película: Avengers");
        lblPelicula.setForeground(new Color(255, 255, 255));
        lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPelicula.setBounds(10, 60, 380, 40);
        panelInfo.add(lblPelicula);

        lblSala = new JLabel("Sala: 4D");
        lblSala.setForeground(new Color(255, 255, 255));
        lblSala.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSala.setBounds(10, 110, 380, 40);
        panelInfo.add(lblSala);

        lblTotal = new JLabel("Total: $ 0");
        lblTotal.setForeground(new Color(255, 255, 255));
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTotal.setBounds(10, 160, 380, 40);
        panelInfo.add(lblTotal);

        JButton btnNewButton_1 = new JButton("Regresar");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(217, 469, 134, 31);
        panelInfo.add(btnNewButton_1);

        // Crear y añadir los JLabels con iconos redimensionados
        JLabel asiOcupado = new JLabel();
        asiOcupado.setIcon(resizeIcon(new ImageIcon("C:\\Users\\Lenovo\\Documents\\Iconos\\chair ocupado.png"), 70, 70));
        asiOcupado.setBounds(52, 263, 70, 70);
        panelInfo.add(asiOcupado);

        JLabel asiDisp = new JLabel();
        asiDisp.setIcon(resizeIcon(new ImageIcon("C:\\Users\\Lenovo\\Documents\\Iconos\\cinema-seat.png"), 70, 70));
        asiDisp.setBounds(159, 263, 70, 70);
        panelInfo.add(asiDisp);

        JLabel asSelect = new JLabel();
        asSelect.setIcon(resizeIcon(new ImageIcon("C:\\Users\\Lenovo\\Documents\\Iconos\\chair_seleccionado.png"), 70, 70));
        asSelect.setBounds(270, 263, 70, 70);
        panelInfo.add(asSelect);

        txtReservados = new JTextField();
        txtReservados.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtReservados.setText("Reservados");
        txtReservados.setBounds(43, 343, 91, 31);
        panelInfo.add(txtReservados);
        txtReservados.setColumns(10);

        txtDisponibles = new JTextField();
        txtDisponibles.setText("Disponibles");
        txtDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtDisponibles.setColumns(10);
        txtDisponibles.setBounds(148, 343, 91, 31);
        panelInfo.add(txtDisponibles);

        txtSuAsiento = new JTextField();
        txtSuAsiento.setText("Su asiento");
        txtSuAsiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtSuAsiento.setColumns(10);
        txtSuAsiento.setBounds(260, 343, 91, 31);
        panelInfo.add(txtSuAsiento);
        
        JButton btnNewButton_2 = new JButton("Continuar");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_2.setBounds(43, 468, 124, 32);
        panelInfo.add(btnNewButton_2);

        // Cargar iconos y redimensionarlos para los botones
        final ImageIcon iconAvailable = new ImageIcon("C:\\Users\\Lenovo\\Documents\\Iconos\\cinema-seat.png");
        Image imgAvailable = iconAvailable.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        final ImageIcon resizedIconAvailable = new ImageIcon(imgAvailable);

        final ImageIcon iconOccupied = new ImageIcon("C:\\Users\\Lenovo\\Documents\\Iconos\\chair_seleccionado.png");
        Image imgOccupied = iconOccupied.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        final ImageIcon resizedIconOccupied = new ImageIcon(imgOccupied);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 12; j++) {
                final JButton btnNewButton = new JButton(resizedIconAvailable);
                btnNewButton.setContentAreaFilled(false);
                btnNewButton.setBorderPainted(false);
                btnNewButton.setOpaque(false);

                btnNewButton.addMouseListener(new MouseAdapter() {
                    private boolean toggled = false;
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (toggled) {
                            btnNewButton.setIcon(resizedIconAvailable);
                            asientosSeleccionados--;
                        } else {
                            btnNewButton.setIcon(resizedIconOccupied);
                            asientosSeleccionados++;
                        }
                        toggled = !toggled;
                        actualizarInformacion();
                    }
                });

                int x = startX + j * (buttonWidth + spaceX);
                int y = startY + i * (buttonHeight + spaceY);

                // Añadir espacio entre la sexta y séptima fila
                if (j >= 6) {
                    x += buttonWidth + spaceX;
                }

                btnNewButton.setBounds(x, y, buttonWidth, buttonHeight);
                contentPane.add(btnNewButton);
            }
        }

        // Añadir ActionListener al botón "Continuar"
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarPeliculas mostrarPeliculas = new MostrarPeliculas();
                mostrarPeliculas.setVisible(true);
            }
        });
    }

    private void actualizarInformacion() {
        lblAsientos.setText("Asientos: " + asientosSeleccionados + " de 3");
        lblTotal.setText("Total: $" + (asientosSeleccionados * PRECIO_POR_ASIENTO));
    }

    // Método para redimensionar iconos
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}

