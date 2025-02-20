package boletin1;

public abstract class Trabajador {
	//Atributos
	private String nombre, dni;

	//Costructores
	public Trabajador(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", dni=" + dni;
	}
	
	
}
