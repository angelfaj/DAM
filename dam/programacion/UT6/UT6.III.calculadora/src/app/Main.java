package app;

import controlador.ControladorCalculadora;
import modelo.ModeloCalculadora;
import vista.VistaCalculadora;

public class Main {

	public static void main(String[] args) {
		ModeloCalculadora modelo = new ModeloCalculadora();
		VistaCalculadora vista = new VistaCalculadora();
		
		ControladorCalculadora controlador = new ControladorCalculadora(vista, modelo);
	}

}
