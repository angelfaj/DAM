package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Contacto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre, telefono;
	private boolean favorito;
	
	public Contacto(String nombre, String telefono, boolean favorito) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.favorito = favorito;
	}
	
	public Contacto() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String isFavorito() {
		if (favorito) {
			return "si";
		}else {
			return "no";
		}
	}
	
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", telefono=" + telefono + ", favorito=" + isFavorito();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}
	
	
	
	
}
