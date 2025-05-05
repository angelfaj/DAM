package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.GestionReserva;
import modelo.Reserva;
import vista.VistaReservas;

public class ControladorReservas implements ActionListener {
	private GestionReserva modelo;
	private VistaReservas vista;
	
	public ControladorReservas(GestionReserva modelo, VistaReservas vista) {
		this.modelo = modelo;
		this.vista = vista;
		iniciar();
	}

	private void iniciar() {
		vista.getBtnReservar().addActionListener(this);
		vista.getBtnCancelar().addActionListener(this);
		vista.getBtnModificar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombreReserva, servicioElegido, idioma, tipoPago;
		
		if (e.getSource() == vista.getBtnCancelar()) {
			try {
				nombreReserva = vista.getTextFieldNombre().getText();
				
				if(modelo.cancelarReservaTxt(new Reserva(nombreReserva, null, null, null))) {
					vista.mostrarOperacion(nombreReserva + " se ha cancelado correctamente");
				}else {
					vista.mostrarOperacion(nombreReserva + " NO se ha cancelado correctamente");
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			vista.limpiarCampos();
		
		}else if(e.getSource() == vista.getBtnReservar()) {
			if (!vista.camposRellenos()) {				//Si no estan los campos rellenos mostramos aviso
				vista.mostrarAviso("Por favor rellena todos los campos");
			} else {
				nombreReserva = vista.getTextFieldNombre().getText();
				servicioElegido = (String)vista.getComboBox().getSelectedItem();
				idioma = vista.getIdioma();
				tipoPago = vista.getPago();
				
				try {
					if (modelo.saveReservaTxt(new Reserva(nombreReserva, servicioElegido, idioma, tipoPago))) {
						vista.mostrarOperacion(nombreReserva + " se ha guardado correctamente");
					}else {
						vista.mostrarOperacion(nombreReserva + " NO se ha guardado correctamente");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				vista.limpiarCampos();
			}
		}else if (e.getSource() == vista.getBtnModificar()) {
			if (!vista.camposRellenos()) {				//Si no estan los campos rellenos mostramos aviso
				vista.mostrarAviso("Por favor rellena todos los campos");
			} else {
				nombreReserva = vista.getTextFieldNombre().getText();
				servicioElegido = (String)vista.getComboBox().getSelectedItem();
				idioma = vista.getIdioma();
				tipoPago = vista.getPago();
				
				try {
					if (modelo.modificarReservaTxt(new Reserva(nombreReserva, servicioElegido, idioma, tipoPago))) {
						vista.mostrarOperacion(nombreReserva + " se ha modificado correctamente");
					}else {
						vista.mostrarOperacion(nombreReserva + " NO se ha modificado correctamente");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				vista.limpiarCampos();
			}
		}
	}
	
}
