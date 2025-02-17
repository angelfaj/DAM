package boletin1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 1 - ASTROS
		Define una jerarquía de clases que permita almacenar datos sobre los planetas y
		satélites (lunas) que forman parte del sistema solar.
		Algunos atributos que necesitaremos almacenar son:
		● Masa del cuerpo.
		● Diámetro medio.
		● Período de rotación sobre su propio eje.
		● Período de traslación alrededor del cuerpo que orbitan.
		● Distancia media a ese cuerpo.
		Define las clases necesarias conteniendo:
		● Constructores.
		● Métodos para recuperar y almacenar atributos.
		● Método para mostrar la información del objeto.
		Define un método, que dado un objeto del sistema solar (planeta o satélite), imprima
		toda la información que se dispone sobre el mismo (además de su lista de satélites
		si los tuviera).
		El diagrama UML sería:
		Una posible solución sería crear un array de objetos, insertar los planetas y satélites
		(directamente mediante código o solicitandonos por pantalla) y luego mostrar un
		pequeño menú que permita al usuario imprimir la información del astro que elija.
		
		FALTA TERMINAR 
		 
		Ejercicio 2 - MASCOTAS
		Implementa una clase llamada Inventario que utilizaremos para almacenar
		referencias a todos los animales existentes en una tienda de mascotas.
		Esta clase debe cumplir con los siguientes requisitos:
		● En la tienda existirán 4 tipos de animales: perros, gatos, loros y canarios.
		● Los animales deben almacenarse en un Array privado dentro de la clase
		Inventario.
		● La clase debe permitir realizar las siguientes acciones:
		○ Mostrar la lista de animales (solo tipo y nombre, 1 línea por animal).
		○ Mostrar todos los datos de un animal concreto.
		○ Mostrar todos los datos de todos los animales.
		○ Insertar animales en el inventario.
		○ Eliminar animales del inventario.
		○ Vaciar el inventario.
		Implementa las demás clases necesarias para la clase Inventario.
		 */
		
		Perro perro = new Perro("Ramon", "10/1/1999", 26, Estado.VIVO, "Doberman", false);
		Gato gato = new Gato("Ares", "10/1/1999", 26, Estado.VIVO, "Negro", true);
		Loro loro = new Loro("Chan", "10/7/2024", 1, Estado.VIVO, true, false, "Puerto Rico", false);
		Canario canario= new Canario("Perico", "10/7/2024", 1, Estado.VIVO, true, false, "Amarillo", false);
		
		Mascota inventario[] = new Mascota[10];
		
		inventario[0] = perro;
		inventario[1] = gato;
		inventario[2] = loro;
		inventario[3] = canario;
		
		Scanner entrada = new Scanner(System.in);
		boolean continuar = true;
		int opcion, opcionAnimal, posicion;
		String nombre = "";
		
		do {
			System.out.println("************MENU TIENDA************");
			System.out.println("1. Mostrar inventario");
			System.out.println("2. Mostrar informacion de un animal");
			System.out.println("3. Mostrar informacion de todos los animales");
			System.out.println("4. Insertar animal");
			System.out.println("5. Eliminar animal");
			System.out.println("6. Vaciar inventario");
			System.out.println("7. Terminar programa");
			System.out.println("Introduce un numero paa continuar: ");
			
			opcion = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcion) {
			case 1:
				for (Mascota m:inventario) {
					if (m != null) {
						System.out.println("Tipo: " + m.getClass() + " nombre: " + m.getNombre());						
					}
				}
				break;
			case 2:
				System.out.println("Introduce el nombre del animal a mostrar: ");
				nombre = entrada.nextLine();
				boolean encontrado = false;
				int i = 0;
				do {
					Mascota m = inventario[i]; 
					if (m != null) {
						if (m.getNombre().equalsIgnoreCase(nombre)) {
							m.muestra();
							encontrado = true;
						}
					}
					i++;
				}while(!encontrado);
				break;
			case 3: 
				for (Mascota m:inventario) {
					if (m != null) {
						m.muestra();						
					}
				}
				break;
			case 4:
				System.out.println("Elige el animal a insertar: ");
				System.out.println("1. Perro");
				System.out.println("2. Gato");
				System.out.println("3. Loro");
				System.out.println("4. Canario");
				System.out.println("Introduce un numero para continuar: ");
				opcionAnimal = entrada.nextInt();
				System.out.println("Introduce la posicion en la que insertarlo: ");
				posicion = entrada.nextInt();
				entrada.nextLine();
				
				switch(opcionAnimal) {
				case 1:
					inventario[posicion] = perro;
					break;
				case 2:
					inventario[posicion] = gato;
					break;
				case 3: 
					inventario[posicion] = loro;
					break;
				case 4: 
					inventario[posicion] = canario;
				break;
				}
				
				break;
			case 5: 
				System.out.println("Introduce el nombre del animal a eliminar: ");
				nombre = entrada.nextLine();
				boolean hayado= false;
				int h = 0;
				do {
					Mascota m = inventario[h]; 
					if (m != null) {
						if (m.getNombre().equalsIgnoreCase(nombre)) {
							inventario[h] = null;
							hayado = true;
						}
					}
					h++;
				}while(!hayado);
				
				break;
			case 6: 
				for (int j = 0; j < inventario.length; j++) {
					inventario[j] = null;
				}
				System.out.println("Inventario vaciado exitosamente");
				break;
			case 7: 
				System.out.println("Fin del programa, Adiós!");
				continuar = false;
				break;
			}
			
			
		}while(continuar);
		entrada.close();
	}

}
