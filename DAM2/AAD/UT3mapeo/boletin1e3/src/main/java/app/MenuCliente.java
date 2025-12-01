package app;

//Paquete: com.catalogo.Clientes.main

import util.HibernateUtil;
import java.util.Scanner;

import dao.ClienteDAOImpl;
import modelo.Cliente;
import servicio.ClienteService;

public class MenuCliente {

	private static ClienteService clienteService;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*3. Gestión de Clientes
		Implementa un sistema que permita realizar operaciones CRUD sobre clientes.
		Cada cliente debe tener un ID, nombre, email y teléfono. Los datos deben
		almacenarse y recuperarse exclusivamente desde la tabla de Oracle
		correspondiente utilizando Hibernate.
		Realiza un menú similar al del ejercicio 1*/
    	
		
		// Inicializar el Service y el DAO
		clienteService = new ClienteService(new ClienteDAOImpl());

		mostrarMenu();

		// Cerrar la SessionFactory al finalizar la aplicación
		HibernateUtil.shutdown();
	}

	public static void mostrarMenu() {
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n--- Gestión de Clientes ---");
			System.out.println("1. Crear Cliente");
			System.out.println("2. Buscar Cliente por ID");
			System.out.println("3. Modificar Cliente");
			System.out.println("4. Eliminar Cliente");
			System.out.println("0. Salir");
			System.out.print("Opción: ");

			try {
				opcion = sc.nextInt();
				sc.nextLine(); // Limpiar buffer

				switch (opcion) {
				case 1:
					crear();
					break;
				case 2:
					leer();
					break;
				case 3:
					actualizar();
					break;
				case 4:
					eliminar();
					break;
				case 0:
					System.out.println("Saliendo del sistema...");
					break;
				default:
					System.out.println("Opción no válida.");
				}
			} catch (Exception e) {
				System.out.println("Error de entrada. Intente de nuevo.");
				sc.nextLine(); // Limpiar la línea de error
				opcion = -1;
			}
		}
	}

	private static void crear() {
		Cliente p = new Cliente();
		System.out.print("Nombre: ");
		p.setNombre(sc.nextLine());
		System.out.print("Email: ");
		p.setEmail(sc.nextLine());
		System.out.print("Telefono: ");
		p.setTelefono(sc.nextLine());

		try {
			clienteService.registrarCliente(p);
			System.out.println("Cliente creado con ID: " + p.getId());
		} catch (Exception e) {
			System.out.println("Error al crear: " + e.getMessage());
		}
	}

	private static void leer() {
		System.out.print("ID del Cliente a buscar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Cliente p = clienteService.obtenerCliente(id);

		if (p != null) {
			System.out.println(p.toString());
		} else {
			System.out.println("No existe el Cliente con ID " + id);
		}
	}

	private static void actualizar() {
		System.out.print("ID del Cliente a modificar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Cliente p = clienteService.obtenerCliente(id);
		if (p == null) {
			System.out.println("No existe el Cliente.");
			return;
		}

		System.out.println("Cliente actual: " + p.getNombre() + ". Ingrese nuevo nombre (o Enter para mantener):");
		String nuevoNombre = sc.nextLine();
		if (!nuevoNombre.isEmpty())
			p.setNombre(nuevoNombre);

		System.out.println("Email actual: " + p.getEmail() + ". Ingrese nuevo email:");
		p.setEmail(sc.nextLine());

		try {
			clienteService.modificarCliente(p);
			System.out.println("Cliente ID " + id + " actualizado.");
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e.getMessage());
		}
	}

	private static void eliminar() {
		System.out.print("ID del Cliente a eliminar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		try {
			clienteService.eliminarCliente(id);
			System.out.println("Cliente ID " + id + " eliminado.");
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e.getMessage());
		}
	}
}