package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VistaAgenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel inputPane;
	private JPanel infoPane;
	private JTextField textFieldNombre;
	private JTextField textFieldNumero;
	private JButton btnGuardar, btnEditar, btnEliminar;
	private JRadioButton rdbtnSi, rdbtnNo;
	private ButtonGroup rdbtnGroup;
	private DefaultTableModel modeloTabla;
	private static final String[] columnas = {"Nombre", "Telefono", "Favorito"};
	private JTable tabla;
	private JScrollPane scrollTabla;
 	
	public VistaAgenda() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		infoPane = new JPanel();
		infoPane.setBackground(new Color(192, 192, 192));
		infoPane.setBounds(212, 37, 212, 155);
		infoPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		infoPane.setLayout(null);
		contentPane.add(infoPane);
		
		inputPane = new JPanel();
		inputPane.setBounds(10, 37, 168, 155);
		inputPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		inputPane.setLayout(null);
		contentPane.add(inputPane);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 11, 103, 14);
		inputPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 25, 103, 20);
		inputPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(10, 56, 103, 14);
		inputPane.add(lblTel);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(10, 69, 103, 20);
		inputPane.add(textFieldNumero);
		
		JLabel lblNewLabel_1 = new JLabel("Favorito:");
		lblNewLabel_1.setBounds(10, 100, 103, 14);
		inputPane.add(lblNewLabel_1);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(4, 113, 52, 23);
		inputPane.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(62, 113, 52, 23);
		inputPane.add(rdbtnNo);
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnNo);
		rdbtnGroup.add(rdbtnSi);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 209, 89, 23);
		contentPane.add(btnGuardar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 209, 69, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar contacto");
		btnEliminar.setBounds(212, 209, 212, 23);
		contentPane.add(btnEliminar);
		
		modeloTabla = new DefaultTableModel(null, columnas);
		tabla = new JTable(modeloTabla);
		scrollTabla = new JScrollPane(tabla);
		scrollTabla.setBounds(10, 11, 192, 133);
		infoPane.add(scrollTabla);
		
		setVisible(true);
		setResizable(false);
	}
	
	public void clearFields() {					//Limpieza de campos
		this.getTextFieldNombre().setText("");
		this.getTextFieldNumero().setText("");
		
		this.getRdbtnGroup().clearSelection();
	}
	
	public void fillTabla(String[][] matriz) {	//Lenar tabla
		modeloTabla.setRowCount(0);
		
		for (String[] persona : matriz) {
			modeloTabla.addRow(persona);
		}
	}
	
	public void mostrarMensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void mostrarMensajeFracaso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getInputPane() {
		return inputPane;
	}

	public JPanel getInfoPane() {
		return infoPane;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldNumero() {
		return textFieldNumero;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}

	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}

	public ButtonGroup getRdbtnGroup() {
		return rdbtnGroup;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JTable getTabla() {
		return tabla;
	}

	public JScrollPane getScrollTabla() {
		return scrollTabla;
	}
}
