package boletin5e7;

import java.util.Objects;

public class Utensilio {
	private String nombre;
	private int unidades;
	
	public Utensilio(String nombre, int cantidad) {
		this.nombre = nombre;
		this.unidades = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return unidades;
	}

	public void setCantidad(int cantidad) {
		this.unidades = cantidad;
	}

	@Override
	public String toString() {
		return "Utensilio [nombre=" + nombre + ", cantidad=" + unidades + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utensilio other = (Utensilio) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
