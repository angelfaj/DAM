package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import model.Departamento;
import model.Empleado;

public class InsertarDatosPersonal {
    public static void main(String[] args) {
        ODB odb = ODBFactory.open("personal.db");

        // 📌 Insertar Departamentos
        Departamento dep1 = new Departamento(10, "Ventas", "Madrid");
        Departamento dep2 = new Departamento(20, "Informática", "Barcelona");
        Departamento dep3 = new Departamento(30, "Recursos Humanos", "Sevilla");
        odb.store(dep1);
        odb.store(dep2);
        odb.store(dep3);

        // 📌 Insertar Empleados
        Empleado jefe1 = new Empleado(1, "López", "Gerente", new Date(), 2500.0f, 0, null, dep1);  // Jefe
        Empleado emp1 = new Empleado(2, "Gómez", "Vendedor", new Date(), 1200.0f, 200.0f, jefe1, dep1);
        Empleado emp2 = new Empleado(3, "Martínez", "Vendedor", new Date(), 900.0f, 100.0f, jefe1, dep1);
        Empleado emp3 = new Empleado(4, "Fernández", "Programador", new Date(), 1800.0f, 0, null, dep2);
        Empleado emp4 = new Empleado(5, "Sánchez", "Técnico", new Date(), 1600.0f, 150.0f, null, dep2);
        Empleado emp5 = new Empleado(6, "Pérez", "Recursos Humanos", new Date(), 1100.0f, 50.0f, null, dep3);
       
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 15); // 15 de junio de 2015
        Date fecha = calendar.getTime();
        Empleado emp6 = new Empleado(7, "Luisa", "Recursos Humanos", fecha, 1100.0f, 50.0f, null, dep3);

        odb.store(jefe1);
        odb.store(emp1);
        odb.store(emp2);
        odb.store(emp3);
        odb.store(emp4);
        odb.store(emp5);
        odb.store(emp6);
       

        odb.close();
        System.out.println("✅ Datos insertados correctamente.");
    }
}
