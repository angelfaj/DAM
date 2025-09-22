package boletin4;

public class Alumno {
	private int nota;
	private String nombre;	//Maximo 10 caracteres
	
	public Alumno(String nombre, int nota) {
		this.nombre = nombre;
		this.nota = nota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [" +nombre + "-"+ nota + "]";
	}
	
	
}
