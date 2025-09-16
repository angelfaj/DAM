package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VistaFormulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JLabel lblEdad;
	private JButton btnEnviar;
	private JTextArea textAreaDatos;
	private JLabel lblDatosRecibidos;
	private JButton btnMostrarTodos;
	private JScrollPane scroll;

	
	public VistaFormulario() {
		setTitle("Formulario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(106, 45, 280, 25);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(106, 81, 46, 25);
		contentPane.add(textFieldEdad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(32, 50, 64, 14);
		contentPane.add(lblNombre);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(32, 86, 46, 14);
		contentPane.add(lblEdad);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(151, 143, 89, 23);
		contentPane.add(btnEnviar);
		
		textAreaDatos = new JTextArea();
//		textFieldDatos.setColumns(10);
		scroll = new JScrollPane(textAreaDatos);
		scroll.setForeground(new Color(0, 0, 0));
		scroll.setFont(new Font("Tahoma", Font.BOLD, 11));
		scroll.setBounds(32, 195, 354, 58);
		contentPane.add(scroll);
		
		lblDatosRecibidos = new JLabel("Datos recibidos:");
		lblDatosRecibidos.setBounds(32, 170, 102, 14);
		contentPane.add(lblDatosRecibidos);
		
		btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.setBounds(272, 143, 114, 23);
		contentPane.add(btnMostrarTodos);
		
		setResizable(false);
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldEdad() {
		return textFieldEdad;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public JTextArea getTextAreadDatos() {
		return textAreaDatos;
	}

	public JLabel getLblDatosRecibidos() {
		return lblDatosRecibidos;
	}

	public JButton getBtnMostrarTodos() {
		return btnMostrarTodos;
	}

	public JScrollPane getScroll() {
		return scroll;
	}
}
