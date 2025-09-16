package clases_uml;

public class Lenguaje {
	public String nombre;
	
	public Lenguaje(String lenguaje) {
		this.nombre = lenguaje;
	}

	@Override
	public String toString() {
		return "\t" + "- " + nombre;
	}
	
	
}
