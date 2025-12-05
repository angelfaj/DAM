package oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainDepartamentoEmpleado {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        // ============================================================
        // 1) ALTA (INSERT) con CascadeType.ALL desde el lado 1
        // ============================================================
        Long idDep = null;

        try (Session s = sf.openSession()) {

            s.beginTransaction();

            Departamento d = new Departamento();
            d.setNombre("Informática");

            Empleado e1 = new Empleado();
            e1.setNombre("Ana");

            Empleado e2 = new Empleado();
            e2.setNombre("Luis");

            // relación bidireccional
            d.getEmpleados().add(e1);
            d.getEmpleados().add(e2);
            e1.setDepartamento(d);
            e2.setDepartamento(d);

            s.persist(d);   // ← AQUÍ SOLO PERSISTO EL DEPTO
                            // Hibernate inserta TAMBIÉN empleados por CASCADE

            s.getTransaction().commit();
            idDep = d.getId();
            System.out.println("INSERTADO departamento con id = " + idDep);
        }


        // ============================================================
        // 2) GET / FIND (lectura)
        // ============================================================
        try (Session s = sf.openSession()) {

            Departamento d2 = s.find(Departamento.class, idDep);

            System.out.println("\nGET/FIND RESULTADO:");
            System.out.println("Departamento: " + d2.getNombre());
            System.out.println("Empleados: ");
            List<Empleado> lista= d2.getEmpleados();
            
            for (Empleado empleado : lista) {
            	System.out.println(" - " + empleado.getNombre());
			}
            
        }


        // ============================================================
        // 3) MODIFICACIÓN (UPDATE) incluyendo orphanRemoval
        // ============================================================
        try (Session s = sf.openSession()) {

            s.beginTransaction();

            idDep=5L;
            Departamento d3 = s.find(Departamento.class, idDep);

            System.out.println("\nMODIFICANDO departamento...");

            // cambiar nombre
            d3.setNombre("Informática y Sistemas");

            // quitar un empleado → orphanRemoval = true lo BORRA de la BD
            Empleado empleadoBorrado = d3.getEmpleados().get(0);
            d3.getEmpleados().remove(empleadoBorrado);

            s.getTransaction().commit();
            System.out.println("Departamento modificado. Empleado eliminado por orphanRemoval.");
        }


        // ============================================================
        // 4) BAJA (DELETE)
        // ============================================================
        try (Session s = sf.openSession()) {

            s.beginTransaction();
            idDep=7L;
            Departamento d4 = s.find(Departamento.class, idDep);

            System.out.println("\nELIMINANDO departamento...");

            s.remove(d4);

            // CASCADE REMOVE → borra también los empleados restantes
            s.getTransaction().commit();

            System.out.println("Departamento y empleados eliminados por cascade.");
        }

        sf.close();
    }
}
