package ejercicio3;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Empresa")
@XmlType(propOrder= {"cif", "empleadosList", "nombre"})
public class Empresa {
	//Atributos
	private String cif;
	private String nombre;
	private Empleados empleadosList;
	
	public Empresa() {}

	@XmlElement(name="cif")
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name="empleados")
	public Empleados getEmpleadosList() {
		return empleadosList;
	}

	public void setEmpleadosList(Empleados empleadosList) {
		this.empleadosList = empleadosList;
	}
	
	
}
