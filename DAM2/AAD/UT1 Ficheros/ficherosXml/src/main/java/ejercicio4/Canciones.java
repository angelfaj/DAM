package ejercicio4;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Canciones")
@XmlType(propOrder={"canciones"}) //Orden en el que aparece en el xml
public class Canciones {
	private ArrayList<Cancion> canciones = new ArrayList<Cancion>();
	
	public Canciones() {}

	@XmlElement(name="canciones")
	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
}
