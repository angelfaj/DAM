package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class VistaFormulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scroll;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextArea textArea;
	private JButton btnEnviar;
	private JCheckBox chckbxBreakfast;
	private JButton btnMostrarTodos;
	
	
	public VistaFormulario() {
		setTitle("Formulario cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 34, 102, 31);
		contentPane.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(26, 75, 102, 31);
		contentPane.add(lblCorreo);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(164, 40, 220, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(164, 81, 220, 19);
		contentPane.add(textFieldEmail);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(174, 152, 85, 21);
		contentPane.add(btnEnviar);
		
		chckbxBreakfast = new JCheckBox("Incluir desayuno");
		chckbxBreakfast.setBounds(164, 125, 142, 21);
		contentPane.add(chckbxBreakfast);
		
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setBounds(27, 179, 376, 74);
		contentPane.add(scroll);
		
		btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.setBounds(318, 152, 85, 21);
		contentPane.add(btnMostrarTodos);
		
		setVisible(true);
		setResizable(false);
	}
	
	public JButton getBtnMostrarTodos() {
		return btnMostrarTodos;
	}
	
	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public JCheckBox getChckbxBreakfast() {
		return chckbxBreakfast;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	
}
