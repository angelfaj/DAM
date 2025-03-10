package excepciones;

import java.util.Scanner;

public class Ejercicio3 {
	public static void showVector(int vector[]) {
		System.out.println("El contenido del vector de enteros es:");
		for (int valor : vector) {
			System.out.println(valor);
		}
	}
	
	public static void fillVector(int vector[], int N) {
		final int NUM = N;
		int posicion = 0;
		Scanner teclado = new Scanner(System.in);
		int cont = 0;
		int divisor = 0;
		
		while (cont < NUM) {
			System.out.println("Introduce una posición del array:");
			posicion = Integer.parseInt(teclado.nextLine());
			System.out.println("Introduce un divisor:");
			try {
				divisor = Integer.parseInt(teclado.nextLine());
				vector[posicion] = 100 / divisor;
			}catch (NumberFormatException e) {
				System.out.println("Valor no entero");
			}
			cont++;
		}
		teclado.close();
	}
	
}
