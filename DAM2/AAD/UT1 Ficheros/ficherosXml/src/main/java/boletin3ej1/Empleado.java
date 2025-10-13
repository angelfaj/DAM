package boletin3ej1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Empleado")
@XmlType(propOrder={"edad", "nombre", "categoria"}) //Orden en el que aparece en el xml
public class Empleado {
	private int edad;
	private String nombre;
	private Categoria categoria;

	public Empleado() {}

	@XmlAttribute(name="edad")
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="categoria")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Empleado [edad=" + edad + ", nombre=" + nombre + "]";
	}

}
