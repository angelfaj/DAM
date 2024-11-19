package ejerciciosFor;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		/*Realiza un programa que sume los 100 números siguientes a un número entero y positivo
		introducido por teclado. Se debe comprobar que el dato introducido es correcto (que es un
		número positivo)*/
		int numero, sumador;
		Scanner entrada = new Scanner(System.in);
		
		
		System.out.printf("Por favor introduce un numero: ");
		numero = entrada.nextInt();
		sumador = numero;
		
		for (int contador = 0; contador < 100 && numero >= 0; contador++) {
			System.out.println(numero += sumador);
			sumador++;
		}
		
	}

}
