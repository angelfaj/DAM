package app;

import controlador.ControladorCine;
import modelo.ModeloCine;
import vista.VistaCine;

public class Main {

	public static void main(String[] args) {		//Esta app pretende simular la compra de entradas para ver una pelicula en el cine
		ModeloCine modelo = new ModeloCine();
		VistaCine vista = new VistaCine();
		
		ControladorCine controlador = new ControladorCine(modelo, vista);
		
		//Pendiente refinar la selección de butacas y el texto guardado, por lo demás es funcional
	}

}
