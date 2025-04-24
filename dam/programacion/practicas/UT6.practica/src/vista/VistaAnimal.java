package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class VistaAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldPeso;
	private JComboBox<String> comboBoxEspecie;
	private final static String[] ESPECIES = {"Perro", "Gato", "Ave", "Conejo"};
	private ButtonGroup rdbtnGroup;
	private JRadioButton rdbtnMacho, rdbtnHembra; 
	private JButton btnGuardarTxt, btnGuardarObj, btnCargarTxt, btnCargarObj; 
	private JTextArea txtrCargaLaInformacin;
	private JScrollPane scrollTextArea;
	
	public VistaAnimal() {
		setTitle("Gestor de animales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldNombre.setBounds(179, 0, 307, 34);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(179, 35, 307, 34);
		contentPane.add(textFieldEdad);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(179, 70, 307, 34);
		contentPane.add(textFieldPeso);
		
		comboBoxEspecie = new JComboBox<String>(ESPECIES);
		comboBoxEspecie.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxEspecie.setBounds(179, 105, 307, 34);
		contentPane.add(comboBoxEspecie);
		
		rdbtnMacho = new JRadioButton("Macho");
		rdbtnMacho.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnMacho.setBounds(179, 154, 149, 23);
		contentPane.add(rdbtnMacho);
		
		rdbtnHembra = new JRadioButton("Hembra");
		rdbtnHembra.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnHembra.setBounds(337, 154, 149, 23);
		contentPane.add(rdbtnHembra);
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMacho);
		rdbtnGroup.add(rdbtnHembra);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombre.setBounds(47, 9, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEdad.setBounds(47, 44, 70, 15);
		contentPane.add(lblEdad);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPeso.setBounds(47, 79, 70, 15);
		contentPane.add(lblPeso);
		
		JLabel lblEspecie = new JLabel("Especie:");
		lblEspecie.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEspecie.setBounds(47, 115, 70, 15);
		contentPane.add(lblEspecie);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSexo.setBounds(47, 158, 70, 15);
		contentPane.add(lblSexo);
		
		btnGuardarTxt = new JButton("Guardar TXT");
		btnGuardarTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGuardarTxt.setBounds(0, 185, 119, 55);
		contentPane.add(btnGuardarTxt);
		
		btnGuardarObj = new JButton("Guardar OBJ");
		btnGuardarObj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGuardarObj.setBounds(125, 185, 119, 55);
		contentPane.add(btnGuardarObj);
		
		btnCargarTxt = new JButton("Cargar TXT");
		btnCargarTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCargarTxt.setBounds(252, 185, 119, 55);
		contentPane.add(btnCargarTxt);
		
		btnCargarObj = new JButton("Cargar OBJ");
		btnCargarObj.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCargarObj.setBounds(379, 185, 119, 55);
		contentPane.add(btnCargarObj);
		
		txtrCargaLaInformacin = new JTextArea();
		txtrCargaLaInformacin.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtrCargaLaInformacin.setText("Carga la información de un fichero pulsando el botón correspondiente.");
		
		scrollTextArea = new JScrollPane(txtrCargaLaInformacin);
		scrollTextArea.setBounds(10, 252, 476, 53);
		contentPane.add(scrollTextArea);
		
		setVisible(true);
		setResizable(false);
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldEdad() {
		return textFieldEdad;
	}

	public JTextField getTextFieldPeso() {
		return textFieldPeso;
	}

	public JComboBox<String> getComboBoxEspecie() {
		return comboBoxEspecie;
	}

	public ButtonGroup getRdbtnGroup() {
		return rdbtnGroup;
	}

	public JRadioButton getRdbtnMacho() {
		return rdbtnMacho;
	}

	public JRadioButton getRdbtnHembra() {
		return rdbtnHembra;
	}

	public JButton getBtnGuardarTxt() {
		return btnGuardarTxt;
	}

	public JButton getBtnGuardarObj() {
		return btnGuardarObj;
	}

	public JButton getBtnCargarTxt() {
		return btnCargarTxt;
	}

	public JButton getBtnCargarObj() {
		return btnCargarObj;
	}

	public JTextArea getTextArea() {
		return txtrCargaLaInformacin;
	}

	public JScrollPane getScrollTextArea() {
		return scrollTextArea;
	}
	
	
}
