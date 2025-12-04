package app;

import java.util.Scanner;

import dao.DetalleLibroDAOImpl;
import dao.LibroDAOImpl;
import modelo.DetalleLibro;
import modelo.Libro;
import servicio.DetalleLibroService;
import servicio.LibroService;
import util.HibernateUtil;

public class App {
	//####################################################
	//############### ACTIVIDAD BOLETIN 2 ################
	//#### MODIFICAR USUARIO Y CONTRASEÑA DE LA BBDD #####
	//####################################################
	private static LibroService libroService;
	private static DetalleLibroService detalleLibroService;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//Inicializamos services y DAOs
		libroService = new LibroService(new LibroDAOImpl());
		detalleLibroService = new DetalleLibroService(new DetalleLibroDAOImpl());

		mostrarMenu();

		// Cerrar la SessionFactory al finalizar la aplicación
		HibernateUtil.shutdown();
	}

	public static void mostrarMenu() {
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n--- Gestión de Libros ---");
			System.out.println("1. Crear Libro");
			System.out.println("2. Crear DetalleLibro");
			System.out.println("3. Buscar Libro por ID");
			System.out.println("4. Buscar DetalleLibro por ID");
			System.out.println("5. Modificar Libro");
			System.out.println("6. Modificar DetalleLibro");
			System.out.println("7. Eliminar Libro");
			System.out.println("8. Eliminar DetalleLibro");
			System.out.println("0. Salir");
			System.out.print("Opción: ");

			try {
				opcion = sc.nextInt();
				sc.nextLine(); // Limpiar buffer

				switch (opcion) {
				case 1:
					crearLibro();
					break;
				case 2:
					crearDetalleLibro();
					break;
				case 3:
					buscarLibro();
					break;
				case 4:
					buscarDetalleLibro();
				case 5:
					modificarLibro();
					break;
				case 6:
					modificarDetalleLibro();
					break;
				case 7:
					eliminarLibro();
					break;
				case 8:
					eliminarDetalleLibro();
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
	
	//CascadeType.ALL hace que independientemente del metodo al que llamemos (creaLibro o crearDetalleLibro se creen ambos en la base de datos.
	private static void crearLibro() {
		Libro l = new Libro();
		DetalleLibro dl = new DetalleLibro();
		
		System.out.print("Autor: ");
		l.setAutor(sc.nextLine());
		System.out.print("Titulo: ");
		l.setTitulo(sc.nextLine());
		System.out.print("DetalleLibro editorial: ");
		dl.setEditorial(sc.nextLine());
		System.out.print("DetalleLibro sinopsis: ");
		dl.setSinopsis(sc.nextLine());
		
		l.setDetalleLibro(dl);
		dl.setLibro(l);
		
		try {
			libroService.registrarLibro(l);
			System.out.println("Libro creado con ID: " + dl.getId());
		} catch (Exception e) {
			System.out.println("Error al crear: " + e.getMessage());
		}
	}

	private static void crearDetalleLibro() {
		Libro l = new Libro();
		DetalleLibro dl = new DetalleLibro();
		
		System.out.print("Autor: ");
		l.setAutor(sc.nextLine());
		System.out.print("Titulo: ");
		l.setTitulo(sc.nextLine());
		System.out.print("DetalleLibro editorial: ");
		dl.setEditorial(sc.nextLine());
		System.out.print("DetalleLibro sinopsis: ");
		dl.setSinopsis(sc.nextLine());
		
		l.setDetalleLibro(dl);
		dl.setLibro(l);
		
		try {
			detalleLibroService.registrarDetalleLibro(dl);
			System.out.println("DetalleLibro creado con ID: " + dl.getId());
		} catch (Exception e) {
			System.out.println("Error al crear: " + e.getMessage());
		}
	}
	
	private static void buscarLibro() {
		System.out.print("ID del Libro a buscar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Libro l = libroService.obtenerLibro(id);

		if (l != null) {
			System.out.println(l.toString());
		} else {
			System.out.println("No existe el libro con ID " + id);
		}
	}
	
	private static void buscarDetalleLibro() {
		System.out.print("ID del DetalleLibro a buscar: ");
		Long id = sc.nextLong();
		sc.nextLine();
		
		DetalleLibro dl = detalleLibroService.obtenerdelleLibro(id);
		
		if (dl != null) {
			System.out.println(dl.toString());
		} else {
			System.out.println("No existe el Detallelibro con ID " + id);
		}
	}

	private static void modificarLibro() {
		System.out.print("ID del Libro a modificar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Libro l = libroService.obtenerLibro(id);
		if (l == null) {
			System.out.println("No existe el Libro.");
			return;
		}

		System.out.println("Libro actual: " + l.getTitulo() + ". Ingrese nuevo titulo (o Enter para mantener):");
		String nuevoNombre = sc.nextLine();
		if (!nuevoNombre.isEmpty())
			l.setTitulo(nuevoNombre);

		System.out.println("Autor actual: " + l.getAutor() + ". Ingrese nuevo autor:");
		l.setAutor(sc.nextLine());

		try {
			libroService.modificarLibro(l);
			System.out.println("Libro ID " + id + " actualizado.");
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e.getMessage());
		}
	}
	
	private static void modificarDetalleLibro() {
		System.out.print("ID del DetalleLibro a modificar: ");
		Long id = sc.nextLong();
		sc.nextLine();
		
		DetalleLibro dl = detalleLibroService.obtenerdelleLibro(id);
		if (dl == null) {
			System.out.println("No existe el DetalleLibro.");
			return;
		}
		
		System.out.println("DetalleLibro actual: " + dl.getSinopsis() + ". Ingrese nueva sinopsis (o Enter para mantener):");
		String nuevaSinopsis = sc.nextLine();
		if (!nuevaSinopsis.isEmpty())
			dl.setSinopsis(nuevaSinopsis);
		
		System.out.println("Editorial actual: " + dl.getEditorial() + ". Ingrese nueva editorial:");
		dl.setEditorial(sc.nextLine());
		
		try {
			detalleLibroService.modificarDetalleLibro(dl);
			System.out.println("DetalleLibro ID " + id + " actualizado.");
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e.getMessage());
		}
	}

	private static void eliminarLibro() {
		System.out.print("ID del Libro a eliminar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		try {
			libroService.eliminarLibro(id);
			System.out.println("Libro ID " + id + " eliminado.");
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e.getMessage());
		}
	}
	
	private static void eliminarDetalleLibro() {
		System.out.print("ID del DetalleLibro a eliminar: ");
		Long id = sc.nextLong();
		sc.nextLine();
		
		try {
			detalleLibroService.eliminarDetalleLibro(id);
			System.out.println("DetalleLibro ID " + id + " eliminado.");
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e.getMessage());
		}
	}
}