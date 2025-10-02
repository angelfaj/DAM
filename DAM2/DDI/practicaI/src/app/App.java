package app;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldClave;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextPane jTextResultado;
	
	public App() {
		setTitle("Formulario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre de usuario:");
		lblIngreseElNombre.setBounds(12, 12, 214, 15);
		contentPane.add(lblIngreseElNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(265, 10, 295, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldClave = new JTextField();
		textFieldClave.setColumns(10);
		textFieldClave.setBounds(265, 66, 295, 19);
		contentPane.add(textFieldClave);
		
		JLabel lblIngreseClave = new JLabel("Ingrese clave:");
		lblIngreseClave.setBounds(12, 68, 214, 15);
		contentPane.add(lblIngreseClave);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Para cambiar el color del texto
				StyledDocument doc = jTextResultado.getStyledDocument();
				SimpleAttributeSet color = new SimpleAttributeSet();

				if (textFieldNombre.getText().isEmpty() || textFieldClave.getText().isEmpty() || !textFieldClave.getText().equals("Aloha1234")) {
					jTextResultado.setText("ERROR");
			        StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
				}else {
					jTextResultado.setText("CORRECTO");
			        StyleConstants.setForeground(color, Color.GREEN); // Cambia a color rojo
				}
				doc.setCharacterAttributes(0, doc.getLength(), color, false);
			}
		});
		btnAceptar.setBounds(265, 118, 117, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setText("");
				textFieldClave.setText("");
				jTextResultado.setText("");
			}
		});
		btnCancelar.setBounds(443, 118, 117, 25);
		contentPane.add(btnCancelar);
		
		jTextResultado = new JTextPane();
		jTextResultado.setEditable(false);
		jTextResultado.setBounds(265, 172, 117, 25);
		contentPane.add(jTextResultado);
		

		setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
