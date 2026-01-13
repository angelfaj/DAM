package dao;

import java.util.Calendar;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import model.Jugador;

public class EmpleadoDAO {
	public static void addEmpleado(Jugador e) {
		ODB odb = ODBFactory.open("personal.db");
		odb.store(e);	
		odb.close();
	}
	
	public static void getAllEmpleados() {
		ODB odb = ODBFactory.open("personal.db");
		Objects<Jugador> empleados = null;
		
		empleados = odb.getObjects(Jugador.class);
		while(empleados.hasNext()) {
			Jugador e = empleados.next();
			System.out.println(e);
		}
		
		odb.close();
	}
	
	public static void mostrarEmplSalarioMasDeMil() {
		ODB odb = ODBFactory.open("personal.db");
		
		ICriterion critSalario = Where.gt("salario", 1000);
		CriteriaQuery query = new CriteriaQuery(Jugador.class, critSalario);
		query.orderByAsc("salario");
		
		Objects<Jugador> empleadosPorSalario = odb.getObjects(query);
		for (Jugador e: empleadosPorSalario) {
			System.out.println(e);
		}
		odb.close();
	}
	
	public static void getEmpleadosFrom2015() {
		ODB odb = ODBFactory.open("personal.db");
		Calendar cal = Calendar.getInstance();

        // Primer día de 2015: 1 de enero de 2015
        cal.set(2015, Calendar.JANUARY, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date primerDia2015 = cal.getTime();

        // Último día de 2015: 31 de diciembre de 2015
        cal.set(2015, Calendar.DECEMBER, 31, 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date ultimoDia2015 = cal.getTime();
        
		ICriterion critDate = new And().add(Where.ge("fecha_alta", primerDia2015)).add(Where.le("fecha_alta", ultimoDia2015));
		CriteriaQuery query = new CriteriaQuery(Jugador.class, critDate);
		query.orderByAsc("fecha_alta");
		
		Objects<Jugador> empleados2015 = odb.getObjects(query);
		for (Jugador e: empleados2015) {
			System.out.println(e);
		}
		odb.close();
	}
	
	public static void getEmpleadosFromDep10() {
		ODB odb = ODBFactory.open("personal.db");
		
		ICriterion critNombre = Where.equal("departamento.id_dep", 10);
		CriteriaQuery query = new CriteriaQuery(Jugador.class, critNombre);
		
		Objects<Jugador> empleadosDep10 = odb.getObjects(query);
		for (Jugador e: empleadosDep10) {
			System.out.println(e);
		}
		odb.close();
	}
	
	public static void getEmpleadosOfPedroLopez() {
		ODB odb = ODBFactory.open("personal.db");
		
		ICriterion critBoss = Where.equal("jefe.apellido", "López");
		CriteriaQuery query = new CriteriaQuery(Jugador.class, critBoss);
		
		Objects<Jugador> empleadosOfBoss = odb.getObjects(query);
		for (Jugador e: empleadosOfBoss) {
			System.out.println(e);
		}
		odb.close();
	}
	
	public static void getNumEmpleadosVentas() {
		ODB odb = ODBFactory.open("personal.db");
		
		ICriterion critVentas = Where.equal("departamento.nombre", "Ventas");
		CriteriaQuery query = new CriteriaQuery(Jugador.class, critVentas);
		
		Objects<Jugador> empleadosVentas = odb.getObjects(query);
		System.out.println("Numero de empleados del departamento Ventas: " + empleadosVentas.size());
		
		odb.close();
	}
	
	public static void getNumEmpleadosPorDep() {
		ODB odb = ODBFactory.open("personal.db");
		
		//Arroja error si algun empleado no tine departamento
		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class)
				.field("departamento.nombre","nombre_departamento")
				.count("id_emp")
				.groupBy("departamento.nombre"));
		
		while (vals.hasNext()) {
			ObjectValues ov = (ObjectValues) vals.next();
			System.out.println("Dept->" + ov.getByAlias("nombre_departamento") + ":" + ov.getByIndex(1));
		}
		odb.close();
	}
}
