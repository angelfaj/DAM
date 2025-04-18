package app;

import controlador.ControladorCC;
import modelo.ModeloCC;
import vista.VistaCC;

public class Main {

	public static void main(String[] args) {
		ModeloCC modelo = new ModeloCC();
		VistaCC vista = new VistaCC();
		ControladorCC controlador = new ControladorCC(vista, modelo);
	}

}
