package app;

import controlador.ControladorBuscador;
import modelo.ModeloBuscador;
import vista.VistaBuscador;

public class Main {

	public static void main(String[] args) {
		ModeloBuscador modelo = new ModeloBuscador();
		VistaBuscador vista = new VistaBuscador();
		
		ControladorBuscador controlador = new ControladorBuscador(vista, modelo);
	}

}
