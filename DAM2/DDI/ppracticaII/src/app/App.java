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
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JButton btnAadirContacto;
	private JTextPane textPane; 
	
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
		
		textField1 = new JTextField();
		textField1.setBounds(171, 39, 114, 19);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(171, 107, 114, 19);
		contentPane.add(textField2);
		
		btnAadirContacto = new JButton("Añadir contacto");
		btnAadirContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String motivoError = "";
				boolean error = false;
				
				if(textField1.getText().isEmpty() || textField2.getText().isEmpty() ) {
					motivoError += "deben rellenarse ambos campos ";
					error = true;
				}
				if (textField1.getText().length() < 8 || textField2.getText().length() < 8) {
					motivoError += " las contraseñas deben tener una longitud superior a ocho caracteres ";
					error = true;
				}
				if(!textField1.getText().equals(textField2.getText())) {
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
