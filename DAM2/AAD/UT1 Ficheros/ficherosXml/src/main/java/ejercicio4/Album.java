package ejercicio4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Album")
@XmlType(propOrder={"anio", "artista", "canciones", "nombre"}) //Orden en el que aparece en el xml
public class Album {
	private String artista, nombre;
	private Canciones canciones;
	private int anio;
	
	public Album() {}

	@XmlAttribute(name="año")
	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@XmlElement(name="artista")
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="canciones")
	public Canciones getCanciones() {
		return canciones;
	}

	public void setCanciones(Canciones canciones) {
		this.canciones = canciones;
	}
	
	
}
