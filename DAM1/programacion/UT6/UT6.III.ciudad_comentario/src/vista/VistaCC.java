package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VistaCC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final static String[] opcionesCombo = { "Madrid", "Barcelona", "Sevilla", "Valencia"};
	private JComboBox<String> comboBox;
	private JTextArea textArea;
	private JButton btnReset, btnMostrarReservas;

	public VistaCC() {
		setTitle("Ciudad y comentarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(20, 26, 84, 13);
		contentPane.add(lblCiudad);
		
		JLabel lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setBounds(20, 85, 84, 13);
		contentPane.add(lblComentarios);
		
		comboBox = new JComboBox<String>(opcionesCombo);
		comboBox.setBounds(126, 26, 158, 21);
		
		contentPane.add(comboBox);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 108, 388, 85);
		contentPane.add(textArea);
		
		btnReset = new JButton("Restaurar valores");
		btnReset.setBounds(168, 217, 85, 21);
		contentPane.add(btnReset);
		
		btnMostrarReservas= new JButton("Mostrar reservas");
		btnMostrarReservas.setBounds(297, 217, 111, 21);
		contentPane.add(btnMostrarReservas);
		
		setVisible(true);
		setResizable(false);
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnReset() {
		return btnReset;
	}
	
	public JButton getBtnMostrar() {
		return btnMostrarReservas;
	}
}
