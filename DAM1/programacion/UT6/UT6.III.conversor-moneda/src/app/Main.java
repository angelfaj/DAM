package app;

import controlador.ControladorConversor;
import modelo.GestionMoneda;
import vista.VistaConversor;

public class Main {

	public static void main(String[] args) {
		GestionMoneda modelo = new GestionMoneda();
		VistaConversor vista = new VistaConversor();
		new ControladorConversor(modelo, vista);
	}

}
