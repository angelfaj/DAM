package Examen;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\nSeleccione una opción:");
			System.out.println("1. Alta de Proyecto");
			System.out.println("2. Baja de Proyecto");
			System.out.println("3. Modificar Proyecto");
			System.out.println("4. Consulta de Proyectos");
			System.out.println("5. Consultar Proyecto con Menor Presupuesto");
			System.out.println("6. Salir");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Para limpiar el buffer de entrada

			switch (opcion) {
			case 1:
				GestionProyectos.altaProyecto();
				break;
			case 2:
				GestionProyectos.bajaProyecto();
				break;
			case 3:
				GestionProyectos.modificarProyecto();
				break;
			case 4:
				GestionProyectos.consultaProyectos();
				break;
			case 5:
				double resul = GestionProyectos.consultarMenorPresupuesto();
				if (resul == -1) {
					System.out.println("No hay proyectos registrados.");
				} else {
					System.out.println("El presupuesto menor es: " + resul);
				}
				break;
			case 6:
				System.out.println("¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Intente nuevamente.");
			}
		} while (opcion != 6);
		
		
		scanner.close();
		
	}

}
