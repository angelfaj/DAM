package app;

import controlador.ControladorFondo;
import vista.VistaFondo;

public class Main {

	public static void main(String[] args) {
		VistaFondo vista = new VistaFondo();
		ControladorFondo controlador = new ControladorFondo(vista);
	}

}
