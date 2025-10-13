package excepciones;

public class Alumno {
	private String nombre;
	private int edad;
	private double nota;
	
	public Alumno (String nombre, int edad)  throws EdadNoValidaException{
		this.nombre = nombre;
		if (edad < 0)
			throw new EdadNoValidaException("La edad debe ser un numero positivo");
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws EdadNoValidaException{
		if (edad < 0) {
			throw new EdadNoValidaException("La edad debe ser un numero positivo");
		} else {
			this.edad = edad;
		}
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) throws NotaNoValidaException{
		if (nota < 0 || nota > 10) {
			throw new NotaNoValidaException("La nota debe estar entre 0 y 10");
		}else {
			this.nota = nota;
		}
	}
	
	
}
