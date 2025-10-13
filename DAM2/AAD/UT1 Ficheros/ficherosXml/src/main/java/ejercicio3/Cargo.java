package ejercicio3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name="Cargo")
@XmlType(propOrder={"nivel", "cargo"}) //Orden en el que aparece en el xml
public class Cargo {
	private int nivel;
	private String cargo;
	
	public Cargo() {}

	@XmlAttribute(name="nivel")
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@XmlValue
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
