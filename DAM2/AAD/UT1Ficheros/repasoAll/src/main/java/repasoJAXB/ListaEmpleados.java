package repasoJAXB;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaEmpleados {
	private ArrayList<Empleado> listaempleados = new ArrayList<Empleado>();

	@XmlElement
	public ArrayList<Empleado> getListaempleados() {
		return listaempleados;
	}

	public void setListaempleados(ArrayList<Empleado> listaempleados) {
		this.listaempleados = listaempleados;
	}
}
