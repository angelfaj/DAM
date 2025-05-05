package app;

import controlador.ControladorReservas;
import modelo.GestionReserva;
import vista.VistaReservas;

public class Main {

	public static void main(String[] args) {
		GestionReserva modelo = new GestionReserva();
		VistaReservas vista = new VistaReservas();
		
		new ControladorReservas(modelo, vista);
	}

}
