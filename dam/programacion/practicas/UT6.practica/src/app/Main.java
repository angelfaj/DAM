package app;

import controlador.ControladorAnimal;
import modelo.Animal;
import vista.VistaAnimal;

public class Main {

	public static void main(String[] args) {
		Animal modelo = new Animal();
		VistaAnimal vista = new VistaAnimal();
		 
		new ControladorAnimal(modelo, vista);
			
	}

}
