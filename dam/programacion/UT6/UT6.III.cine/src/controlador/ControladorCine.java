package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import modelo.ModeloCine;
import vista.VistaCine;

public class ControladorCine implements ActionListener {
	private ModeloCine modelo;
	private VistaCine vista;
	
	public ControladorCine(ModeloCine modelo, VistaCine vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		iniciar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Recogemos los datos introducidos
		String pelicula = (String) vista.getComboBoxFilms().getSelectedItem();
		String email = vista.getTextFieldEmail().getText();
		boolean disabled = false;
		
		if (vista.getRdbtnSi().isSelected()) {
			disabled = true;
		}
		
		String butaca = "";
		int fila= vista.getTable().getSelectedRow();
		int columna = vista.getTable().getSelectedColumn();
		if (fila != -1 && columna != -1) {
			butaca = (String) vista.getTable().getValueAt(fila, columna);
		}
		
		//Guardamos los datos
		try {
			modelo = new ModeloCine(email, pelicula, disabled, butaca);
			JOptionPane.showMessageDialog(vista, "Factura txt: " + modelo.showFacturaTxt() + "\n" + "Factura bin: " + modelo.showFacturaBin() + "\n" + "Facturas txt:" + modelo.showAllFacturaTxt() + "\n" + "Facturas bin:" + modelo.showAllFacturaBin());
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void iniciar() {
		vista.getBtnNewEnviar().addActionListener(this);
		vista.fillTable(cargarDatosMatriz());
		
	}
	
	private String[][] cargarDatosMatriz() {		
		String[][] datosTabla = new String[8][8];
		
		for (int i = 0; i < datosTabla.length; i++) {
			for (int j = 0; j < datosTabla[i].length; j++) {
				datosTabla[i][j] = j + 1 + "";
			}
		}
		return datosTabla;
	}
	
}
