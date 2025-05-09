package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modelo.Equipo;
import modelo.GestionEquipos;
import vista.VistaGestion;

public class ControladorGestion implements ActionListener {
	private GestionEquipos modelo;
	private VistaGestion vista;
	
	public ControladorGestion(GestionEquipos modelo, VistaGestion vista) {
		this.modelo = modelo;
		this.vista = vista;
		iniciar();
	}

	private void iniciar() {
		vista.getBtnBuscarTxt().addActionListener(this);
		vista.getBtnGuardarObj().addActionListener(this);
		vista.getBtnGuardarTxt().addActionListener(this);
		vista.getBtnMostrarObj().addActionListener(this);
		vista.clearFields(); //Por si acaso limpiamos todos los campos
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnBuscarTxt()) {	//Buscamos numero de serie en txt
			try {
				vista.getTextArea().setText(modelo.searchEquipoTxt(vista.getTextFieldNumeroSerie().getText()));
			} catch (IOException e1) {
				vista.showMessage("Ocurrió un error de entrada salida");
			} 
		}else if (e.getSource() == vista.getBtnGuardarObj()) {//Guardamos en fichero de objetos
			try {
				modelo.saveEquipoDat(getEquipoFromFields());
				vista.showMessage("Equipo guardado correctamente");
			} catch (IOException e1) {
				vista.showMessage("Ocurrió un error de entrada salida");
			}
		}else if (e.getSource() == vista.getBtnGuardarTxt()) {//Guardamos en txt y mostramos cuantos tipos existen del mismo pc
			Equipo equipo = getEquipoFromFields();
			try {
				modelo.saveEquipoTxt(equipo);
				vista.showMessage("Equipo guardado correctamente");
				vista.getTextArea().setText(modelo.countPcTipes(equipo.getTipo()));
			} catch (IOException e1) {
				vista.showMessage("Ocurrió un error de entrada salida");
			}catch (ClassNotFoundException e2) {
				vista.showMessage("No se encontró la clase del objeto");
			}
		}else if (e.getSource() == vista.getBtnMostrarObj()) {	//Mostramos todos los equipos guardados en el fichero de objetos
			try {
				vista.clearFields();
				vista.getTextArea().setText(modelo.getAllEquiposDat());
			} catch (ClassNotFoundException e1) {
				vista.showMessage("No se encontró la clase del objeto");
			} catch (IOException e1) {
				vista.showMessage("Ocurrió un error de entrada salida");
			} 
		}
	}
	
	private Equipo getEquipoFromFields() {		//Crea un objeto equipo a partir de los campos del formulario
		String nSerie = vista.getTextFieldNumeroSerie().getText();
		String marca = vista.getTextFieldMarca().getText();
		int anio = Integer.parseInt(vista.getTextFieldAnio().getText());
		String tipo = (String) vista.getComboBoxTipo().getSelectedItem();
		boolean ssd = false, ram = false, wifi = false, gpu = false;
		
		if (vista.getChckbxGpuDedicada().isSelected()) {
			gpu = true;
		}
		if (vista.getChckbxRamgb().isSelected()) {
			ram = true;
		}
		if (vista.getChckbxSsd().isSelected()) {
			ssd = true;
		}
		if (vista.getChckbxWifiIntegrado().isSelected()) {
			wifi = true;
		}
		
		Equipo e = new Equipo(nSerie, marca, anio, tipo, ssd, ram, wifi, gpu);
		return e;
	}
}
