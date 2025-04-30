package clases_uml;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Lenguaje> lenguajes = new ArrayList<Lenguaje>();
		
		lenguajes.add(new Lenguaje("C"));
		lenguajes.add(new Lenguaje("C++"));
		lenguajes.add(new Lenguaje("Python"));
		lenguajes.add(new Lenguaje("Java"));
		
		Programador p1 = new Programador("Pepe", "Perez", lenguajes);
		
		p1.mostrarLenguajes();
	}

}
