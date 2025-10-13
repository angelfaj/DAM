package boletin5e3;

public class Alumno extends Persona{
	private static final long serialVersionUID = 1L;
	Fecha fecha;
	
	public Alumno(String nif, String nombre, int edad) {
		super(nif, nombre, edad);
	}

	public Alumno(String nif, String nombre, int edad, Fecha fecha) {
		super(nif, nombre, edad);
		this.fecha = fecha;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "[" + nif + ", " + nombre + ", " + edad + ", " + fecha + "]";
	}
	
	
	
}
