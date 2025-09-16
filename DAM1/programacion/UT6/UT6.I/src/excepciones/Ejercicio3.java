package excepciones;

import java.util.Scanner;

public class Ejercicio3 {
	public static void showVector(int vector[]) {
		System.out.println("El contenido del vector de enteros es:");
		for (int valor : vector) {
			System.out.println(valor);
		}
	}
	
	public static void fillVector(int vector[], int N) throws IndexOutOfBoundsException, ArithmeticException{ //El mismo metodo sin throws seria funcional sin embargo de esta forma obtenemos una maor legibilidad en el código, sabiendo que métodos pueden arrojar que errores 
		final int NUM = N;
		int posicion = 0;
		Scanner teclado = new Scanner(System.in);
		int cont = 0;
		int divisor = 0;
		
		while (cont < NUM) {
			System.out.println("Introduce una posición del array:");
			posicion = Integer.parseInt(teclado.nextLine());
			if (posicion < 0 || posicion >= 5) {						//ESte if representa el lanzamiento manual de una excepcion, de esta forma podriamos personalizar la activacion de las mismas
				throw new ArrayIndexOutOfBoundsException("Array fuera de rango");
			}
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
