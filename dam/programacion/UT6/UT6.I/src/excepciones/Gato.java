package excepciones;

public class Gato {
	private String nombre;
	private int edad;
	
	public Gato(String nombre, int edad) throws EdadNoValidaException, NombreGatoException {
		setNombre(nombre);
		setEdad(edad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreGatoException {
		if (!nombre.matches("\\w{3,}"))
			throw new NombreGatoException("El nombre debe tener al menos 3 caracteres");
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws EdadNoValidaException {
		if (edad < 0)
			throw new EdadNoValidaException("La edad debe ser un numero positivo");
		this.edad = edad;
	}

	public void imprimir() {
		System.out.println("Gato: " + nombre + "-" + edad);
	}

}
