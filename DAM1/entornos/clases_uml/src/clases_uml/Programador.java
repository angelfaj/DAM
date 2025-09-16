package clases_uml;

import java.util.ArrayList;

public class Programador extends Persona{
	ArrayList<Lenguaje> lenguajes;
	
	public Programador(String nombre, String apellido, ArrayList<Lenguaje> lenguajes) {
		super(nombre, apellido);
		this.lenguajes = lenguajes;
	}
	
	public void agregarLenguaje(ArrayList<Lenguaje> lenguajes) {
		this.lenguajes = lenguajes;
	}
	
	public void mostrarLenguajes() {
		presentarse(); 
		System.out.println("Conozco los lenguajes: ");
		for (Lenguaje l : lenguajes) {
			System.out.println(l);
		}
	}

}
