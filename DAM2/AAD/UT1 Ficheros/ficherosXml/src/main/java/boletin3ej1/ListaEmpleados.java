package boletin3ej1;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="listaempleados")
@XmlType(propOrder = {"listaEmpleados"}) 
public class ListaEmpleados {
	private ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

	public ListaEmpleados() {}

	@XmlElement(name="listaempleados")
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	
}
