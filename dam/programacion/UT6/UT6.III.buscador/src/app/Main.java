package app;

import controlador.ControladorBuscador;
import modelo.ModeloBuscador;
import vista.VistaBuscador;

public class Main {

	public static void main(String[] args) {		//Esta app es un buscador de coincidencias dentro de un texte predefinido, permite contar caracteres, palabras y lineas.
		ModeloBuscador modelo = new ModeloBuscador();
		VistaBuscador vista = new VistaBuscador();
		
		ControladorBuscador controlador = new ControladorBuscador(vista, modelo);
	}

}
