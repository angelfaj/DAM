package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import model.Empleado;

public class EmpleadoDAO {
	public static void addEmpleado(Empleado e) {
		ODB odb = ODBFactory.open("personal.db");
		odb.store(e);	
		odb.close();
	}
	
	public static void getAllEmpleados() {
		ODB odb = ODBFactory.open("personal.db");
		Objects<Empleado> empleados = null;
		
		empleados = odb.getObjects(Empleado.class);
		while(empleados.hasNext()) {
			Empleado e = empleados.next();
			System.out.println(e);
		}
		
		odb.close();
	}
}
