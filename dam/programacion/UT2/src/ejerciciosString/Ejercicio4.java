package ejerciciosString;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		/*Crea un programa en Java que solicite al usuario un texto y cuente cuántas vocales mayúsculas
		y minúsculas aparecen al final de cada palabra en el texto. El proceso se repetirá hasta que el
		usuario introduzca la palabra "Fin" (ignorando mayúsculas y minúsculas). No se permite usar el
		método split().*/
		
		Scanner entrada = new Scanner(System.in);
		final String FIN = "fin";
		final String DELIMITADOR = " ";
		final String VOCALES = "aeiouAEIOU";
		
		String texto = "";
		int contadorMayusculas, contadorMinusculas;
		char comparador;
		
		do {
			System.out.println("Introduce un texto (escribe 'Fin' para terminar): ");
			texto = entrada.nextLine();
			
			if (!texto.equalsIgnoreCase(FIN)) {
				
				contadorMayusculas = 0;
				contadorMinusculas = 0;
					
				for (int i = texto.lastIndexOf(DELIMITADOR); i < texto.length(); i++ ) {
					comparador = texto.charAt(i);
					if ((VOCALES.indexOf(comparador) >= 0) && (VOCALES.indexOf(comparador) <= 4)) {
						contadorMinusculas++;
					} else if ((VOCALES.indexOf(comparador) >= 5) && (VOCALES.indexOf(comparador) <= 9)) {
						contadorMayusculas++;
					}
				}
				System.out.println("Numero de vocales minusculas de la ultima palabra: " + contadorMinusculas);
				System.out.println("Numero de vocales mayusculas de la ultima palabra: " + contadorMayusculas);
				
				
			} else {
				System.out.println("Programa finalizado");
			}
						
		} while (!texto.equalsIgnoreCase(FIN));
		
		entrada.close();
		
	}

}
