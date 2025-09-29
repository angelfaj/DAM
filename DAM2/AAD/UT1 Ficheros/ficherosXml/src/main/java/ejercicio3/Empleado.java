package ejercicio3;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Empleado")
@XmlType(propOrder={"dni","nombre","edad", "cargo"}) //Orden en el que aparece en el xml
public class Empleado {
	private String dni, nombre;
	Cargo cargo;
	private int edad;
	
	public Empleado() {}

	@XmlElement(name="dni")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="edad")
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@XmlElement(name="cargo")
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
