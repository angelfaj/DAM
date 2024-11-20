package examen;
import java.util.Scanner;

public class Examen {

	public static void main(String[] args) {
		//Crear una pirámide con un numero de filas N solicitadas al usuario, cada fila empezará en 1, si el número es multiplo de 3 lo sustituimos por un asterisco, si es multiplo de cinco por una almohadilla, si es de ambos por un arroba 
		
		Scanner entrada = new Scanner(System.in);
		int numeroFilas;		//Será el número de filas de nuestra prirámide
		String fila = "";		//String que almacenará los datos a mostrar en cada línea
		
		
		do {					//Bucle que solicitara un número de nuevo si el introducido es negativo
			System.out.println("Por favor introduce un número: ");
			numeroFilas = entrada.nextInt();
			
			if (numeroFilas > 0) {								//Condicional que dará paso al programa principal si el numero introducido es positivo

				for (int i = 1; i != numeroFilas + 1; i++) {	//Bucle para imprimir cada linea con sus respectivos simbolos y números
					
					if ((i%3 == 0) && (i%5 == 0)) {				//Condicional que determina el simbolo a imprimir segun el valor
						fila += "@" + " ";		
					} else if (i%5 == 0) {		
						fila += "#" + " ";
					} else if (i%3 == 0){		
						fila += "*" + " ";	
					} else {					
						fila += i + " ";
					}
					System.out.println(fila);

				}
			}
		} while (numeroFilas <= 0); 
		
		System.out.println("Fin del programa!");
		entrada.close();

	}

}
