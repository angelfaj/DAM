package app;

import controlador.ControladorGestion;
import modelo.GestionEquipos;
import vista.VistaGestion;

public class Main {

	public static void main(String[] args) {
		GestionEquipos modelo = new GestionEquipos();
		VistaGestion vista = new VistaGestion();
		new ControladorGestion(modelo, vista);
	}

}
