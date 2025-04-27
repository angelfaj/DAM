package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.Contacto;
import modelo.GestionContacto;
import vista.VistaAgenda;

public class ControladorAgenda implements ActionListener{
	private VistaAgenda vista;
	private GestionContacto modelo;
	
	public ControladorAgenda(VistaAgenda vista, GestionContacto modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		iniciar();
	}

	private void iniciar() {
		refreshTabla();
		vista.getBtnEditar().addActionListener(this);
		vista.getBtnGuardar().addActionListener(this);
		vista.getBtnEliminar().addActionListener(this);
	}
	
	private void refreshTabla() {		//Este metodo matendra la tabla actualiza en todo momento
		try {
			vista.fillTabla(modelo.getMatrizContactos());
		} catch (FileNotFoundException e) {
			vista.mostrarMensajeFracaso(e.getMessage());
		} catch (ClassNotFoundException e) {
			vista.mostrarMensajeFracaso(e.getMessage());
		} catch (IOException e) {
			vista.mostrarMensajeFracaso(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnGuardar()) {
			boolean favorito = false;
			if (vista.getRdbtnSi().isSelected()) {
				favorito = true;
			}
			try {
				modelo.saveContacto(new Contacto(vista.getTextFieldNombre().getText(), vista.getTextFieldNumero().getText(), favorito));
				vista.mostrarMensajeExito("Contacto guardado correctamente");
				refreshTabla();
				vista.clearFields();
			} catch (IOException e1) {
				vista.mostrarMensajeFracaso(e1.getMessage());
			}
		}else if (e.getSource() == vista.getBtnEditar()) {
			//Volcamos el contacto de la tabla en un objeto contacto y en los textfield
			Contacto aux = getContactoSelectedFromTabla();
			
			vista.getTextFieldNombre().setText(aux.getNombre());
			vista.getTextFieldNumero().setText(aux.getTelefono());
			
			//Borramos el contacto viejo
			try {
				modelo.deleteContacto(aux);
				refreshTabla();
			} catch (FileNotFoundException e1) {
				vista.mostrarMensajeFracaso(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				vista.mostrarMensajeFracaso(e1.getMessage());
			} catch (IOException e1) {
				vista.mostrarMensajeFracaso(e1.getMessage());
			}
			
			//Tras editar los datos el usuario pulsara guardar y el flujo continuara 
		}else if (e.getSource() == vista.getBtnEliminar()) {
			try {
				modelo.deleteContacto(getContactoSelectedFromTabla());
				vista.mostrarMensajeExito("Contacto eliminado correctamente");
				refreshTabla();
				vista.clearFields();
			} catch (FileNotFoundException e1) {
				vista.mostrarMensajeExito("Contacto eliminado correctamente");
			} catch (ClassNotFoundException e1) {
				vista.mostrarMensajeExito("Contacto eliminado correctamente");
			} catch (IOException e1) {
				vista.mostrarMensajeExito("Contacto eliminado correctamente");
			}
		}
	}
	
	private Contacto getContactoSelectedFromTabla() {		//Devuelve un objeto contacto a partir del contacto seleccionado en la tabla
		Contacto contactoSeleccionado = null;
		int fila = vista.getTabla().getSelectedRow();
		String nombre = (String) vista.getTabla().getValueAt(fila, 0);
		String telefono = (String) vista.getTabla().getValueAt(fila, 1);
		String fav = (String) vista.getTabla().getValueAt(fila, 2);
		boolean favorito = false;
		
		if(fav.equalsIgnoreCase("si")) {
			favorito = true;
			vista.getRdbtnSi().setSelected(true);
		}else {
			vista.getRdbtnNo().setSelected(true);
		}
		contactoSeleccionado = new Contacto(nombre, telefono, favorito);
		
		return contactoSeleccionado;
	}

}
