package ejercicio3;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Empleados")
@XmlType(propOrder= {"empleadosList"})
public class Empleados {
	private ArrayList<Empleado> empleadosList = new ArrayList<Empleado>();
	
	public Empleados() {}

	@XmlElement(name="empleados")
	public ArrayList<Empleado> getEmpleadosList() {
		return empleadosList;
	}

	public void setEmpleadosList(ArrayList<Empleado> empleadosList) {
		this.empleadosList = empleadosList;
	}
	
}
