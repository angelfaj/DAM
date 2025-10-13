package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class VistaConversor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, conversorPane, historicPane;
	private JTextField textFieldCantidadOrigen;
	private JTextField textFieldCantidadDestino;
	private JComboBox<String> comboBoxMonedaOrigen, comboBoxMonedaDestino;
	private JButton btnConvertir;
	private DefaultTableModel modeloTabla;
	private JTable tabla;
	private JScrollPane scroll;
	private static final String[] COLUMNAS = {"Moneda", "Moneda"};
	private static final String[] MONEDAS = {"Euro", "Dolar"};
	
	public VistaConversor() {
		setTitle("Conversor Euro-Dolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		conversorPane = new JPanel();
		conversorPane.setBounds(10, 11, 414, 142);
		contentPane.add(conversorPane);
		conversorPane.setLayout(null);
		
		historicPane = new JPanel();
		historicPane.setBounds(10, 164, 414, 118);
		contentPane.add(historicPane);
		historicPane.setLayout(null);
		historicPane.setBorder(new TitledBorder("HISTÓRICO CONVERSIONES"));
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(165, 108, 89, 23);
		conversorPane.add(btnConvertir);
		
		comboBoxMonedaOrigen = new JComboBox<String>(MONEDAS);
		comboBoxMonedaOrigen.setBounds(10, 44, 170, 22);
		conversorPane.add(comboBoxMonedaOrigen);
		
		comboBoxMonedaDestino = new JComboBox<String>(MONEDAS);
		comboBoxMonedaDestino.setBounds(234, 44, 170, 22);
		conversorPane.add(comboBoxMonedaDestino);
		
		textFieldCantidadOrigen = new JTextField();
		textFieldCantidadOrigen.setBounds(10, 77, 170, 20);
		conversorPane.add(textFieldCantidadOrigen);
		textFieldCantidadOrigen.setColumns(10);
		
		textFieldCantidadDestino = new JTextField();
		textFieldCantidadDestino.setColumns(10);
		textFieldCantidadDestino.setBounds(234, 77, 170, 20);
		conversorPane.add(textFieldCantidadDestino);
		
		JLabel lblNewLabel = new JLabel("Moneda origen:");
		lblNewLabel.setBounds(10, 19, 170, 14);
		conversorPane.add(lblNewLabel);
		
		JLabel lblMonedaDestino = new JLabel("Moneda destino:");
		lblMonedaDestino.setBounds(234, 19, 170, 14);
		conversorPane.add(lblMonedaDestino);
		
		modeloTabla = new DefaultTableModel(null, COLUMNAS); 
		tabla = new JTable(modeloTabla);
		scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 24, 394, 83);
		historicPane.add(scroll);
		
		setVisible(true);
		setResizable(false);
	}
	
	public void showMessage(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void refreshTabla(String[][] matriz) {
		modeloTabla.setRowCount(0);
		
		for (String[] fila : matriz) {
			modeloTabla.addRow(fila);
		}
	}

	public JTextField getTextFieldCantidadOrigen() {
		return textFieldCantidadOrigen;
	}

	public JTextField getTextFieldCantidadDestino() {
		return textFieldCantidadDestino;
	}

	public JComboBox<String> getComboBoxMonedaOrigen() {
		return comboBoxMonedaOrigen;
	}

	public JComboBox<String> getComboBoxMonedaDestino() {
		return comboBoxMonedaDestino;
	}

	public JButton getBtnConvertir() {
		return btnConvertir;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public JTable getTabla() {
		return tabla;
	}

	public JScrollPane getScroll() {
		return scroll;
	}
	
	
}
