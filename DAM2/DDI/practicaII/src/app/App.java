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
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAadirContacto;
	private JTextPane textPane; 
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	
	public App() {
		setTitle("Verificación de contraseña");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(153, 193, 241));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(0, 62, 255));
		lblContrasea.setBounds(183, 12, 83, 15);
		contentPane.add(lblContrasea);
		
		JLabel lblRepiteLaContrasea = new JLabel("Repite la contraseña");
		lblRepiteLaContrasea.setForeground(new Color(0, 62, 255));
		lblRepiteLaContrasea.setBounds(158, 80, 148, 15);
		contentPane.add(lblRepiteLaContrasea);
		
		btnAadirContacto = new JButton("Añadir contacto");
		btnAadirContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String motivoError = "";
				boolean error = false;
				
				if(passwordField1.getPassword().length < 1 || passwordField2.getPassword().length < 1 ) {
					motivoError += "deben rellenarse ambos campos ";
					error = true;
				}
				if (new String(passwordField1.getPassword()).length() < 8 || new String(passwordField2.getPassword()).length() < 8) {
					motivoError += " las contraseñas deben tener una longitud superior a ocho caracteres ";
					error = true;
				}
				if(!new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword()))) {
					motivoError += "las contraseñas no coinciden";
					error = true;
				}
				//Objetos necesarios para manipular el color del resultado mostrado en el textpane
				StyledDocument doc = textPane.getStyledDocument();
				SimpleAttributeSet color = new SimpleAttributeSet();
				
				if (error) {
					textPane.setText("ERROR <" + motivoError + ">");
					 StyleConstants.setForeground(color, Color.RED); // Cambia a color rojo
				}else {
					textPane.setText("CORRECTO");
					 StyleConstants.setForeground(color, Color.GREEN); // Cambia a color verde
				}
				doc.setCharacterAttributes(0, doc.getLength(), color, false);
			}
		});
		btnAadirContacto.setBounds(158, 138, 146, 25);
		contentPane.add(btnAadirContacto);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 179, 424, 74);
		contentPane.add(textPane);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(171, 38, 114, 19);
		contentPane.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(171, 107, 114, 19);
		contentPane.add(passwordField2);
		
		
		
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
