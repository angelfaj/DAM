package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaBuscador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textAreaTexto; 
	private JTextField textFieldWord;
	private JButton btnBuscar;
	private JScrollPane scrollText, scrollCoincidencias;
	private JTable tablaCoincidencias;
	private DefaultTableModel modeloTabla;
	private final String[] columnasTabla = {"Patrón", "Ocurrencias"};

	public VistaBuscador() {
		setTitle("Buscador de palabras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAreaTexto = new JTextArea();
		scrollText = new JScrollPane(textAreaTexto);
		scrollText.setSize(182, 182);
		scrollText.setLocation(10, 45);
		contentPane.add(scrollText);
		
		JLabel lblNewLabel = new JLabel("Texto:");
		lblNewLabel.setBounds(10, 25, 78, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblBuscador = new JLabel("Buscador:");
		lblBuscador.setBounds(278, 25, 78, 13);
		contentPane.add(lblBuscador);
		
		textFieldWord = new JTextField();
		textFieldWord.setBounds(227, 62, 96, 19);
		contentPane.add(textFieldWord);
		textFieldWord.setColumns(10);
		
		JLabel lblPatrn = new JLabel("Patrón:");
		lblPatrn.setBounds(227, 45, 78, 13);
		contentPane.add(lblPatrn);
		
		modeloTabla = new DefaultTableModel(null, columnasTabla);
		tablaCoincidencias = new JTable(modeloTabla);
		
		scrollCoincidencias = new JScrollPane(tablaCoincidencias);
		scrollCoincidencias.setBounds(227, 138, 182, 89);
		contentPane.add(scrollCoincidencias);
		
		btnBuscar = new JButton("Buscar coincidencias");
		btnBuscar.setBounds(227, 97, 182, 21);
		contentPane.add(btnBuscar);
		
		setVisible(true);
		setResizable(false);
	}

	public void mostrarTabla(String[] text) {	//Llena la tabla
		modeloTabla.setRowCount(0); 			//Limpia la tabla
		!!!!
		crear metodo que devuelva matriz con cada fila a mostrar ?
				otra froma de añadir a la tabla?
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextArea getTextAreaTexto() {
		return textAreaTexto;
	}

	public JTextField getTextFieldWord() {
		return textFieldWord;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JScrollPane getScrollText() {
		return scrollText;
	}

	public JScrollPane getScrollCoincidencias() {
		return scrollCoincidencias;
	}

}
