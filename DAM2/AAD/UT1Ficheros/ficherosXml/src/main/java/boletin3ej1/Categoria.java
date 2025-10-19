package boletin3ej1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="Categoria")
@XmlType(propOrder = {"plus"})
public class Categoria {
	private int plus;
	private String categoria;
	
	public Categoria() {}
 
	@XmlValue
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@XmlAttribute(name="plus")
	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}
	
	@Override
	public String toString() {
		return "Categoria [plus=" + plus + ", categoria=" + categoria + "]";
	}
	
}
