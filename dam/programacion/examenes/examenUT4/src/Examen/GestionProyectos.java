package Examen;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class GestionProyectos {
	//Atributos
	private static ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
	private static HashMap<Integer, Double> mapaProyectos = new HashMap<Integer, Double>();
	private static double arrayProyectos[] = new double[10];
	
 	//Metodos
	public static void altaProyecto() {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Ingrese el ID del proyecto:");
		int id = scanner1.nextInt();
		scanner1.nextLine(); // Limpiar buffer
		System.out.println("Ingrese el nombre del proyecto:");
		String nombre = scanner1.nextLine();
		System.out.println("Ingrese la fecha de inicio del proyecto (dd/mm/aaaa):");
		String fechaInicio = scanner1.nextLine();
		System.out.println("Ingrese la fecha de fin del proyecto (dd/mm/aaaa):");
		String fechaFin = scanner1.nextLine();
		System.out.println("Ingrese el estado del proyecto (En progreso, Completado, Pendiente):");
		String estado = scanner1.nextLine();
		System.out.println("Ingrese el presupuesto del proyecto:");
		double presupuesto = scanner1.nextDouble();
		scanner1.nextLine();

		
		Proyecto p = new Proyecto(id, nombre, fechaInicio, fechaFin, estado, presupuesto);
		
		if (listaProyectos.contains(p)) {							//Comprobamos si existe 
			System.out.println("El proyecto ya esta registrado");
		} else {													//Lo añadimos a nuestras estructuras
			listaProyectos.add(p);
			mapaProyectos.put(id, presupuesto);
			arrayProyectos[id] = presupuesto;
			System.out.println("Proyecto registrado exitósamente");
		}

	}

	public static void bajaProyecto() {
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Ingrese el ID del proyecto a eliminar:");
		int id = scanner2.nextInt();
		scanner2.nextLine(); // Limpiar buffer
		
		boolean continuar = true;
		int i = -1;

		mapaProyectos.remove(id);
		while (continuar && i < listaProyectos.size()) {		
			i++;
			if (listaProyectos.get(i).getId() == id) {			//Recorremos la lista de proyectos en busca del proyecto con el ID solicitado
				listaProyectos.remove(i);
				arrayProyectos[i] = 0.0; 
				System.out.println("El proyecto ha sido eliminado");
				continuar = false;
			}
		}
	}

	public static void modificarProyecto() {
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Ingrese el ID del proyecto a modificar:");
		int id = scanner3.nextInt();
		scanner3.nextLine(); // Limpiar buffer
		
		for (Proyecto p : listaProyectos) {								//Buscamos el proyecto en la lista de proyectos
			if (p.getId() == id) {									
				System.out.println("Ingrese el nombre del proyecto:");
				String nombre = scanner3.nextLine();
				System.out.println("Ingrese la fecha de inicio del proyecto (dd/mm/aaaa):");
				String fechaInicio = scanner3.nextLine();
				System.out.println("Ingrese la fecha de fin del proyecto (dd/mm/aaaa):");
				String fechaFin = scanner3.nextLine();
				System.out.println("Ingrese el estado del proyecto (En progreso, Completado, Pendiente):");
				String estado = scanner3.nextLine();
				System.out.println("Ingrese el presupuesto del proyecto:");
				double presupuesto = scanner3.nextDouble();

				
				p.setNombre(nombre);									//Actualizamos los valores en el proyecto
				p.setFechaInicio(fechaInicio);
				p.setFechaFin(fechaFin);
				p.setEstado(estado);
				p.setPresupuesto(presupuesto);

				mapaProyectos.put(id, presupuesto);						//Actualizamos nuestras estructuras con los nuevos valores
				arrayProyectos[id] = presupuesto;
				System.out.println("Proyecto actualizado exitósamente");
			}
		}
		

	}

	public static void consultaProyectos() {
		Collections.sort(listaProyectos);					//Ordenamos los proyectos por nombre
		Iterator<Proyecto> it = listaProyectos.iterator();
		
		while (it.hasNext()) {								//Mostramos la info requerida
			Proyecto p = it.next();
			System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() +
					", Fecha inicio: " + p.getFechaInicio() + ", Fecha fin: " +
					p.getFechaFin() + ", Estado: " + p.getEstado() + 
					", Presupuesto: " + p.getPresupuesto());
			System.out.println("En el mapa: " + mapaProyectos.get(p.getId()));
			System.out.println("En el array: " + arrayProyectos[p.getId()]);
		}
	}

	public static double consultarMenorPresupuesto() {
		double presupuestoMin = -1;
		
		if (mapaProyectos.isEmpty()) {
			return presupuestoMin;
		} else {
			Iterator<Double> it2 = mapaProyectos.values().iterator();
			double presupuestoAux = 1000000000000000000000000.00;				//Valor auxiliar para quedarnos con el presupuesto menor
			while (it2.hasNext()) {
				presupuestoMin = it2.next();
				if (presupuestoAux < presupuestoMin) {
					presupuestoMin = presupuestoAux;
				}
				presupuestoAux = presupuestoMin;
			}
		}
		return presupuestoMin;
	}
}