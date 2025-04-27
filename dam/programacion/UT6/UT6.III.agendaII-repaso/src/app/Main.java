package app;

import controlador.ControladorAgenda;
import modelo.GestionContacto;
import vista.VistaAgenda;

public class Main {

	public static void main(String[] args) {
		VistaAgenda vista = new VistaAgenda();
		GestionContacto modelo = new GestionContacto();
		new ControladorAgenda(vista, modelo);
	}

}
