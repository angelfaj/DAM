package formulario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JLabel lblEdad;
	private JButton btnEnviar;
	private JTextField textFieldDatos;
	private JLabel lblDatosRecibidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
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
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDatos.setText("Nombre: " + textFieldNombre.getText() + ", edad: " + textFieldEdad.getText());
			}
		});
		btnEnviar.setBounds(173, 114, 89, 23);
		contentPane.add(btnEnviar);
		
		textFieldDatos = new JTextField();
		textFieldDatos.setForeground(new Color(0, 0, 0));
		textFieldDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldDatos.setEnabled(false);
		textFieldDatos.setBounds(32, 195, 354, 25);
		contentPane.add(textFieldDatos);
		textFieldDatos.setColumns(10);
		
		lblDatosRecibidos = new JLabel("Datos recibidos:");
		lblDatosRecibidos.setBounds(32, 170, 102, 14);
		contentPane.add(lblDatosRecibidos);
		
		setResizable(false);
	}
}
