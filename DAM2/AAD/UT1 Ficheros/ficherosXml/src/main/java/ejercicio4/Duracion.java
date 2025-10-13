package ejercicio4;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="Duracion")
@XmlType(propOrder={"extra", "duracion"}) //Orden en el que aparece en el xml
public class Duracion {
	private String extra;
	private int duracion;
	
	public Duracion() {}

	@XmlAttribute(name="extra")
	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@XmlValue
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return duracion + "(extra=" + extra + ")";
	}
	
	
}
