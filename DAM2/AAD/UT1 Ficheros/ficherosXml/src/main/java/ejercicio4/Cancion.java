package ejercicio4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Cancion")
@XmlType(propOrder={"titulo", "duracion"}) //Orden en el que aparece en el xml
public class Cancion {
	private String titulo;
	private Duracion duracion;
	
	public Cancion() {}

	@XmlElement(name="titulo")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@XmlElement(name="duracion")
	public Duracion getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", duracion=" + duracion + "]";
	}

	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}
	
	
}
