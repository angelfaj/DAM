package boletinRepaso;

import java.util.Objects;

public abstract class Curso implements Comparable<Object> {
	private Integer id; //Para usarlo en el metodo compareTO se inicializa asi: Integer number = new Integer(10)
	private String nombre;
	private int horas;
	private int precio;
	
	public Curso(int id, String nombre, int horas, int precio) {
		this.id = id;
		this.horas = horas;
		this.precio = precio;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return id == other.id && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Object o) {
		Curso c = (Curso) o;
		if (this.getNombre().equals(c.getNombre())) {
			return this.getId().compareTo(c.getId());
		} else {
			return this.getNombre().compareTo(c.getNombre());
		}
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", precio=" + precio;
	}
	
	
	
}
