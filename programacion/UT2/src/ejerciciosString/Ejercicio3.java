package ejerciciosString;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		/*Crea un programa en Java que pida al usuario introducir un texto. El programa debe contar el
		número de vocales mayúsculas y minúsculas que contiene el texto. El proceso se repetirá hasta
		que el usuario introduzca la palabra "Fin" (sin distinción entre mayúsculas y minúsculas).*/
		
		Scanner entrada = new Scanner(System.in);
		final String FIN = "Fin";
		final String VOCALES = "aeiouAEIOU"; //0-4 minúsculas, 5-9 mayúsculas
				
		String texto = "";
		int contadorMayusculas, contadorMinusculas;
		char comparador;
		
		
		do {
			System.out.println("Introduce un texto (escribe 'Fin' para terminar): ");
			texto = entrada.nextLine();
			
			if (!texto.equalsIgnoreCase(FIN)) {
				contadorMinusculas = 0;
				contadorMayusculas = 0;
				
				for (int i = 0; i < texto.length(); i++) {
					comparador = texto.charAt(i);
					if ((VOCALES.indexOf(comparador) >= 0) && (VOCALES.indexOf(comparador) <= 4)) {
						contadorMinusculas++;
					} else if ((VOCALES.indexOf(comparador) >= 5) && (VOCALES.indexOf(comparador) <= 9)) {
						contadorMayusculas++;
					}
				}
				System.out.println("Numero de vocales minusculas: " + contadorMinusculas);
				System.out.println("Numero de vocales mayusculas: " + contadorMayusculas);
				
			} else {
				System.out.println("Programa finalizado.");
			}
			
		} while (!texto.equalsIgnoreCase(FIN));
		
		entrada.close();
	}

}
