package dao;


import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import model.Departamento;

public class DepartamentoDAO {
	public static void addDepartamento(Departamento d) {
		ODB odb = ODBFactory.open("personal.db");
		odb.store(d);	
		odb.close();
	}
	
	public static void getAllDepartamentos() {
		ODB odb = ODBFactory.open("personal.db");
		Objects<Departamento> departamentos = null;
		
		departamentos = odb.getObjects(Departamento.class);
		while(departamentos.hasNext()) {
			Departamento d = departamentos.next();
			System.out.println(d);
		}
		
		odb.close();
	}
}
