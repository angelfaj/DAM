package ejerciciosDowhile;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		/*MRealiza el control de acceso a una caja fuerte. La combinación será un número de 4 cifras
		que tú elijas (no hace falta pedir al usuario). El programa nos pedirá la combinación para
		abrirla. Si no acertamos, se nos mostrará el mensaje “Lo siento, esa no es la combinación” y
		si acertamos se nos dirá “La caja fuerte se ha abierto satisfactoriamente”. Tendremos cuatro
		oportunidades para abrir la caja fuerte*/
		int userPin, intentos = 0;
		final int PIN = 4567;
		Scanner entrada = new Scanner(System.in);
				
		do {
			System.out.printf("\nPor favor introduce la combinacion para abrir la caja fuerte: ");
			userPin = entrada.nextInt();
			intentos++;
			entrada.nextLine();
			
			
		} while ((userPin != PIN) && (intentos != 4));

	}

}
