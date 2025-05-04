package controlador;

import modelo.GestionReserva;
import vista.VistaReservas;

public class ControladorReservas {
	private GestionReserva modelo;
	private VistaReservas vista;
	
	public ControladorReservas(GestionReserva modelo, VistaReservas vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		
		iniciar();
	}

	private void iniciar() {
		
	}
	

}
