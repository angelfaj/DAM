package ejerciciosWhile;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		//Realiza un programa que nos diga cuántos dígitos tiene un número introducido por teclado.
		
		int numero, contador = 0;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Por favor introduce un número: ");
		numero = entrada.nextInt();
		entrada.close();
		
		while (numero > 0) {
			numero /= 10;
			contador++;
		}
		System.out.println("El número introducido tiene "+contador+" dígitos");
	}

}
