package ejerciciosDowhile;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		/*Escribe un programa que lea una lista de diez números y escriba por pantalla cuántos son
		positivos, y cuántos son negativos*/
		int numero, contador = 0, positivos = 0, negativos = 0;
		Scanner entrada = new Scanner(System.in);
		
		 do {
			 System.out.printf("Por favor introduce un numero positivo o negativo: ");
			 numero = entrada.nextInt();
			 
			 if (numero >= 0) {
				 positivos++;
			 } else {
				 negativos++;
			 }
			 
			 contador++;
		 } while (contador < 10);
		 
		 System.out.println("En total hay "+positivos+" positivos y "+negativos+" negativos");
	}

}
