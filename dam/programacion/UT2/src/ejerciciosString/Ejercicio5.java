package ejerciciosString;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		/*Pedir un pin al usuario, tiene tres intentos como maximo, cada fallo dira si ha acertado alguna letra y en que posicion esta.
		 EJ: pin = hola
		 usuario escribe: mola
		 programa devuelve: 123
		 */
		
		Scanner entrada = new Scanner(System.in);
		final String PIN = "adios";
		final int TRY = 3;
		
		String pin, aciertos;
		
		for (int i = 0; (i < TRY); i++) {
			System.out.print("\nIntroduce el pin: ");
			pin = entrada.nextLine();
			
			aciertos = "";
			if (pin.equalsIgnoreCase(PIN)) {
				System.out.println("¡Acertaste!");
				i += 2;
			} else {
				for (int j = 0; j < pin.length(); j++) {
					if (pin.charAt(j) == PIN.charAt(j)) {
						aciertos += j;
					}
				}
				System.out.println("Número de aciertos: " + aciertos);
			}
		}
		
		System.out.println("Fin del programa");
		entrada.close();
	}

}
