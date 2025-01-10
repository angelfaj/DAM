package estructurasDinamicas;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/*Ejercicio 1
		Realizar un programa que lea tantos números enteros como desee el
		usuario (se pedirá dicha información al usuario) y los introduzca en una
		lista (ArrayList).
		Muestra la lista, intercambia los números que se encuentren en la 2a y 4a
		posición, y muestra de nuevo la lista por pantalla. Utiliza al menos 3
		métodos: uno para introducir los datos, otro para mostrarlos y otro para
		intercambiarlos.
		
		
		ArrayList<Integer> enteros = new ArrayList<Integer>();
		boolean op = true;
		int opcion;
		
		
		
		while (op) {
			System.out.println("1. Introducir un numero" + "\n" + "2. Finalizar lectura");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Numero: ");
				enteros.add(entrada.nextInt());				
				break;
			case 2:
				System.out.println("Adios!");
				op = false;
				break;
			}
			
		}
		entrada.close();
		System.out.println("La lista contiene los siguientes elementos: " + enteros);
		int aux = enteros.get(3);
		enteros.set(3, enteros.get(1));
		enteros.set(1, aux);
		
		
		
		System.out.println("La lista contiene los siguientes elementos: " + enteros);
		*/
		
		
		/*Ejercicio 2
		Un supermercado nos pide que hagamos una pequeña aplicación que
		almacene los productos pasados por el escáner.
		La aplicación debe almacenar Productos (clase), cada producto al crearse
		contiene un nombre, cantidad y un precio. Calcular el precio total de una
		lista (ArrayList) de entre 1 y 8 productos (se pide por consola introducir
		productos hasta que se introduzca ”FIN”). Mostrar un ticket con todo lo
		vendido y el precio final como se hacen en los supermercados. Más o
		menos con este formato, lo importante son los datos, no el estilo:
		***********Cantidad****Precio*******Total
		Jamón 5 3.5 17.5
		Queso 7 2.5 17.5
		Precio final
		35
		
		boolean continuar = true;
		String nombre;
		int cantidad, i = 0;
		final int LIMITE = 8;
		double precio;
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();		//Lista para manipular los productos en el main
		
		while (continuar & (i < LIMITE)) {
			System.out.println("FIN para terminar" + "\n" + "Nombre del producto:");
			nombre = entrada.nextLine();
			if (nombre.equalsIgnoreCase("fin")) {
				continuar = false;
			} else {
				System.out.println("Cantidad (int):");
				cantidad = entrada.nextInt();
				System.out.println("Precio (double):");
				precio = entrada.nextDouble();
				entrada.nextLine();
				Producto p = new Producto(nombre, cantidad, precio);
				listaProductos.add(p);
			}
			i++;
		}
		
		System.out.println(Producto.showTicket());
		
		*/
		
		/*Ejercicio 3
		Escribe un programa que contenga un método que acepte como
		parámetro una lista (ArrayList) de números enteros mayores
		que 0, pudiendo contener elementos duplicados. Implementa un método
		que sustituya cada valor repetido por 0. Para terminar, realiza un método
		que muestre el array modificado.
		Nota: Necesitarás otro método para rellenar la lista de enteros. Le irá
		pidiendo números al usuario hasta que este introduzca un número
		negativo
		
		
		
		OperaArray listaEnteros = new OperaArray();
		
		listaEnteros.fillArray();

		System.out.println("La lista original es: " + listaEnteros.toString());
		listaEnteros.verifyArray();
		System.out.println("La lista tras modificar los repes es: " + listaEnteros.toString());
		.*/
		
		
		/*EJERCICIO 1
		Crea un programa en Java para la gestión de temperaturas. Inicialmente, se presenta un
		menú en pantalla para elegir la opción deseada:
		l.
		2.
		3.
		4.
		5.
		6.
		7.
		Añadir temperatura
		Mostrar temperatura media
		Mostrar temperaturas extremas
		Mostrar la lista de temperaturas
		Busca la temperatura y muestra su posición
		Borrar la temperatura
		Salir
		El menú se volverá a presentar de nuevo en la pantalla tras completar cualquiera de las 6
		primeras opciones.
		Cada número de menú se implementará en un método estático que nos permite llevar a cabo la
		operación con la lista de temperaturas que se defina en el programa. Los datos se solicitarán al
		usuario, utiliza la clase Scanner para ello. Se guardará en un ArrayList las temperaturas.*/
		
		
		
		
		
		
		
		
	}

}
