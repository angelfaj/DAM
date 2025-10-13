package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre, tour, idioma, pago;

	public Reserva(String nombre, String tour, String idioma, String pago) {
		super();
		this.nombre = nombre;
		this.tour = tour;
		this.idioma = idioma;
		this.pago = pago;
	}

	public Reserva() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTour() {
		return tour;
	}

	public void setTour(String tour) {
		this.tour = tour;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return nombre + "-" + tour + "-" + idioma + "-" + pago;
	}

	@Override
	public boolean equals(Object obj) {		//No puede haber dos reservas con el mismo nombre
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
	
}
