package app.repasoClase;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Vehiculo")
@XmlType(propOrder={"precio", "anio", "marca", "modelo", "vendedor"}) //Orden en el que aparece en el xml
public class Vehiculo {
	private int anio;
	private double precio;
	private String marca;
	private String vendedor;
	private String modelo;
	
	public Vehiculo() {}

	@XmlAttribute(name="precio")
	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@XmlElement(name="precio")
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@XmlElement(name="marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@XmlElement(name="vendedor")
	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	@XmlElement(name="modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [anio=" + anio + ", precio=" + precio + ", marca=" + marca + ", vendedor=" + vendedor
				+ ", modelo=" + modelo + "]";
	}
}

