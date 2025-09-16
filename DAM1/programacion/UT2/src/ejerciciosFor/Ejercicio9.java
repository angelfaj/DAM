package ejerciciosFor;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		//Escribe un programa que calcule el factorial de un número entero leído por teclado.
		Scanner entrada = new Scanner(System.in);
		int numero, factorial;
		
		System.out.printf("Por favor introduce un número para calcular su factorial: ");
		numero = entrada.nextInt();
		entrada.close();
		factorial = numero;
		
		for (int numero2 = 1; numero2 < numero; numero2++) {
			factorial *= numero2;
			
		}
		System.out.println("El factorial de "+numero+" es "+factorial);
	}

}
