package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;

public class VistaGestion extends JFrame {

	private JPanel contentPane, inputPane, buttonPane;
	private JTextArea textArea;
	private JScrollPane scrollTextArea;
	private JButton btnGuardarTxt, btnGuardarObj, btnMostrarObj, btnBuscarTxt;
	private JLabel lblMarca;
	private JLabel lblAoDeCompra;
	private JLabel lblTipo;
	private JTextField textFieldNumeroSerie;
	private JTextField textFieldMarca;
	private JTextField textFieldAnio;
	private JCheckBox chckbxSsd, chckbxRamgb, chckbxGpuDedicada, chckbxWifiIntegrado;
	private JComboBox<String> comboBoxTipo;
	private static final String[] TIPOS = {"Portátil", "Sobremesa", "All-in-one"};
	
	
	public VistaGestion() {
		setTitle("Gestion de equipos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		inputPane = new JPanel();
		inputPane.setBounds(12, 0, 474, 140);
		inputPane.setLayout(null);
		contentPane.add(inputPane);
		
		JLabel lblNumeroDeSerie = new JLabel("Numero de serie:");
		lblNumeroDeSerie.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumeroDeSerie.setBounds(12, 12, 142, 15);
		inputPane.add(lblNumeroDeSerie);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 39, 142, 15);
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(lblMarca);
		
		lblAoDeCompra = new JLabel("Año de compra:");
		lblAoDeCompra.setBounds(12, 66, 142, 15);
		lblAoDeCompra.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(lblAoDeCompra);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 97, 142, 15);
		lblTipo.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(lblTipo);
		
		textFieldNumeroSerie = new JTextField();
		textFieldNumeroSerie.setBounds(172, 10, 114, 19);
		textFieldNumeroSerie.setFont(new Font("Arial", Font.PLAIN, 14));
		inputPane.add(textFieldNumeroSerie);
		textFieldNumeroSerie.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(172, 37, 114, 19);
		textFieldMarca.setFont(new Font("Arial", Font.PLAIN, 14));
		inputPane.add(textFieldMarca);
		
		textFieldAnio = new JTextField();
		textFieldAnio.setColumns(10);
		textFieldAnio.setBounds(172, 64, 114, 19);
		textFieldAnio.setFont(new Font("Arial", Font.PLAIN, 14));
		inputPane.add(textFieldAnio);
		
		comboBoxTipo = new JComboBox<String>(TIPOS);
		comboBoxTipo.setBounds(172, 92, 114, 24);
		comboBoxTipo.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(comboBoxTipo);
		
		chckbxSsd = new JCheckBox("SSD");
		chckbxSsd.setBounds(311, 8, 129, 23);
		chckbxSsd.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(chckbxSsd);
		
		chckbxRamgb = new JCheckBox("RAM > 8GB");
		chckbxRamgb.setBounds(311, 35, 129, 23);
		chckbxRamgb.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(chckbxRamgb);
		
		chckbxGpuDedicada = new JCheckBox("GPU dedicada");
		chckbxGpuDedicada.setBounds(311, 62, 129, 23);
		chckbxGpuDedicada.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(chckbxGpuDedicada);
		
		chckbxWifiIntegrado = new JCheckBox("Wifi integrado");
		chckbxWifiIntegrado.setBounds(311, 93, 129, 23);
		chckbxWifiIntegrado.setFont(new Font("Arial", Font.BOLD, 14));
		inputPane.add(chckbxWifiIntegrado);
		
		buttonPane = new JPanel();
		buttonPane.setBounds(12, 251, 474, 52);
		buttonPane.setLayout(null);
		contentPane.add(buttonPane);
		
		btnGuardarObj = new JButton("Guardar OBJ");
		btnGuardarObj.setBounds(0, 12, 124, 27);
		btnGuardarObj.setFont(new Font("Arial", Font.BOLD, 14));
		buttonPane.add(btnGuardarObj);
		
		btnGuardarTxt = new JButton("Guardar TXT");
		btnGuardarTxt.setBounds(120, 12, 120, 27);
		btnGuardarTxt.setFont(new Font("Arial", Font.BOLD, 14));
		buttonPane.add(btnGuardarTxt);
		
		btnMostrarObj = new JButton("Mostrar OBJ");
		btnMostrarObj.setBounds(346, 12, 122, 27);
		btnMostrarObj.setFont(new Font("Arial", Font.BOLD, 14));
		buttonPane.add(btnMostrarObj);
		
		btnBuscarTxt = new JButton("Buscar TXT");
		btnBuscarTxt.setBounds(240, 12, 112, 27);
		btnBuscarTxt.setFont(new Font("Arial", Font.BOLD, 14));
		buttonPane.add(btnBuscarTxt);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		scrollTextArea = new JScrollPane(textArea);
		scrollTextArea.setBounds(12, 152, 474, 87);
		contentPane.add(scrollTextArea);
		
		setVisible(true);
		setResizable(false);
	}
	
	public void showMessage(String txt) {			//Metodo para mostrar avisos
		JOptionPane.showMessageDialog(this, txt);
	}
	
	public void clearFields() {		//Limpia el formulario
		textArea.setText("");
		textFieldAnio.setText("");
		textFieldMarca.setText("");
		textFieldNumeroSerie.setText("");
		chckbxGpuDedicada.setSelected(false);
		chckbxRamgb.setSelected(false);
		chckbxSsd.setSelected(false);
		chckbxWifiIntegrado.setSelected(false);
		comboBoxTipo.setSelectedIndex(0);
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JScrollPane getScrollTextArea() {
		return scrollTextArea;
	}

	public JButton getBtnGuardarTxt() {
		return btnGuardarTxt;
	}

	public JButton getBtnGuardarObj() {
		return btnGuardarObj;
	}

	public JButton getBtnMostrarObj() {
		return btnMostrarObj;
	}

	public JButton getBtnBuscarTxt() {
		return btnBuscarTxt;
	}

	public JTextField getTextFieldNumeroSerie() {
		return textFieldNumeroSerie;
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarca;
	}

	public JTextField getTextFieldAnio() {
		return textFieldAnio;
	}

	public JCheckBox getChckbxSsd() {
		return chckbxSsd;
	}

	public JCheckBox getChckbxRamgb() {
		return chckbxRamgb;
	}

	public JCheckBox getChckbxGpuDedicada() {
		return chckbxGpuDedicada;
	}

	public JCheckBox getChckbxWifiIntegrado() {
		return chckbxWifiIntegrado;
	}

	public JComboBox<String> getComboBoxTipo() {
		return comboBoxTipo;
	}
	
}
