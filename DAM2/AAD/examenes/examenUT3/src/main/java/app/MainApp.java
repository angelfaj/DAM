package app;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Coche;
import modelo.Concesionario;
import modelo.Sede;
import servicio.ConcesionarioService;
import servicio.ConcesionarioServiceImpl;
import util.HibernateUtil;

public class MainApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ConcesionarioService service = new ConcesionarioServiceImpl();

    public static void main(String[] args) {
        mostrarMenu();
        HibernateUtil.shutdown(); 
    }

    private static void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n--- GESTIÓN DE CONCESIONARIOS (HIBERNATE 6) ---");
            System.out.println("1. Insertar datos (Concesionario, Sede y 2 Coches)");
            System.out.println("2. Consultar - Navegación de Propiedades (Todas las sedes)");
            System.out.println("3. Consultar - Por Nombre y Ciudad (Parámetros)");
            System.out.println("4. Actualizar Nombre de Concesionario");
            System.out.println("5. Eliminar Concesionario (y sus asociados)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcion) {
                    case 1: insertarDatos(); break;
                    case 2: service.mostrarDatosSedeTodosConcesionarios(); break;
                    case 3: consultarPorParametros(); break;
                    case 4: actualizarNombre(); break;
                    case 5: eliminarDatos(); break;
                    case 0: System.out.println("Saliendo de la aplicación..."); break;
                    default: System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Entrada no válida. Por favor, introduzca un número.");
                scanner.nextLine(); 
                opcion = -1;
            }
        } while (opcion != 0);
    }

    private static void insertarDatos() {
        System.out.println("\n--- 2.1: Inserción de Concesionario Completo ---");
        
        System.out.print("Nombre del Concesionario: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Calle de la Sede: ");
        String calle = scanner.nextLine();
        System.out.print("Ciudad de la Sede: ");
        String ciudad = scanner.nextLine();
        
        System.out.print("Modelo Coche 1: ");
        String m1 = scanner.nextLine();
        System.out.print("Matrícula Coche 1: ");
        String mat1 = scanner.nextLine();
        
        System.out.print("Modelo Coche 2: ");
        String m2 = scanner.nextLine();
        System.out.print("Matrícula Coche 2: ");
        String mat2 = scanner.nextLine();
        
        Concesionario c = new Concesionario(nombre);
        Sede s = new Sede(calle, ciudad);
        Coche c1 = new Coche(m1, mat1);
        Coche c2 = new Coche(m2, mat2);
        
        service.guardarConcesionarioCompleto(c, s, c1, c2);
    }

    private static void consultarPorParametros() {
        System.out.println("\n--- 2.2.b: Consulta por Nombre de Concesionario y Ciudad ---");
        System.out.print("Introduzca Nombre del Concesionario: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduzca Ciudad de la Sede: ");
        String ciudad = scanner.nextLine();
        
        service.mostrarConcesionarioPorNombreYCiudad(nombre, ciudad);
    }

    private static void actualizarNombre() {
        System.out.println("\n--- 2.3: Actualizar Nombre de Concesionario ---");
        System.out.print("Introduzca ID del Concesionario a modificar: ");
        
        try {
            Long id = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.nextLine();
            
            service.modificarNombre(id, nuevoNombre);
        } catch (InputMismatchException e) {
            System.err.println("ID no válido.");
            scanner.nextLine();
        }
    }
    
    private static void eliminarDatos() {
        System.out.println("\n--- 2.4: Eliminar Concesionario por ID ---");
        System.out.print("Introduzca ID del Concesionario a eliminar: ");
        
        try {
            Long id = scanner.nextLong();
            scanner.nextLine();
            
            service.eliminarConcesionario(id);
        } catch (InputMismatchException e) {
            System.err.println("ID no válido.");
            scanner.nextLine();
        }
    }
}