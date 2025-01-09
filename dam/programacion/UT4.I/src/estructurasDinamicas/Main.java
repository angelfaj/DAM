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
		35*/
		
		System.out.println("Introduce un numero ");
		
	}

}
