package boletin5e7;

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
	
	
}
