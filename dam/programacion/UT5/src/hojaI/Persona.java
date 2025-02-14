package hojaI;

public class Persona {
	//Atributos
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private Estado estado;
	
	//Constructores
	public Persona() {}
	
	public Persona(String nombre, String apellido1, String apellido2, String dni, Estado estado) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.estado = estado;				
	}

	//Metodos
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}
	
	
	@Override
	public String toString() {
		return "[nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", estado=" + estado;
	}
	
	
	
	
}
