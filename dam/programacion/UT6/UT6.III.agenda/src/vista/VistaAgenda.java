package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.PersonaModelo;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAgenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldNombre;
	private JTextField textFieldNumero;
	private JButton btnAniadirContacto, btnEditarContacto, btnEliminarContacto;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;

	
	public VistaAgenda() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 31, 70, 15);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(22, 57, 114, 19);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(22, 96, 70, 15);
		contentPane.add(lblTelfono);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(22, 122, 114, 19);
		contentPane.add(textFieldNumero);
		
		btnAniadirContacto = new JButton("Añadir/Guardar contacto");
		btnAniadirContacto.setBounds(22, 187, 146, 25);
		contentPane.add(btnAniadirContacto);
		
		btnEditarContacto = new JButton("Editar contacto");
		btnEditarContacto.setBounds(270, 187, 142, 25);
		contentPane.add(btnEditarContacto);
		
		btnEliminarContacto = new JButton("Eliminar contacto");
		btnEliminarContacto.setBounds(145, 228, 156, 25);
		contentPane.add(btnEliminarContacto);
		
		String[] columnas = {"Nombre", "Telefono"};
		modeloTabla = new DefaultTableModel(null, columnas);
		table = new JTable(modeloTabla);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 17, 240, 158);
		contentPane.add(scrollPane);

		
		setResizable(false);
        setVisible(true);

	}
	
	public void mostrarTabla(String[][] personas) {		//Llena la tabla
		  modeloTabla.setRowCount(0); // Limpia la tabla

		    for (String[] persona : personas) {
		        modeloTabla.addRow(persona);
		    }
	}
	
	public PersonaModelo getSelectectPersona() {		//Devuelve un objeto persona de la fila seleccionada en la tabla
		int filaSeleccionada = table.getSelectedRow();
		PersonaModelo persona = null;
		if (filaSeleccionada != -1) {
			String nombre = (String) table.getValueAt(filaSeleccionada, 0);
			String telefono= (String) table.getValueAt(filaSeleccionada, 1);
			persona = new PersonaModelo(nombre, telefono);
		}
		return persona;
	}
	
	public JButton getBtnAniadir() {
		return btnAniadirContacto;
	}
	
	public JButton getBtnEditar() {
		return btnEditarContacto;
	}
	
	public JButton getBtnEliminar() {
		return btnEliminarContacto;
	}
	
	public JTextField getTxtNombre() {
		return textFieldNombre;
	}
	
	public JTextField getTxtNumero() {
		return textFieldNumero;
	}
	
	public void setTxtFieldNombre(String nombre) {
		textFieldNombre.setText(nombre);
	}
	
	public void setTxtFieldNumero(String numero) {
		textFieldNumero.setText(numero);
	}
	
	
}
