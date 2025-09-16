package clases_uml;

public class Persona {
	public String nombre;
	public String apellido;
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public void presentarse() {
		System.out.println("Hola, me llamo " + nombre);
	}
	
}
