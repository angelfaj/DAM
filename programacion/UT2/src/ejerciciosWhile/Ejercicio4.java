package ejerciciosWhile;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		/*Escribe un programa que calcule la media de un conjunto de números positivos introducidos
		por teclado. A priori, el programa no sabe cuántos números se introducirán. El usuario indicará
		que ha terminado de introducir los datos cuando meta un número negativo.*/
		
		int media = 0,contador = -1, numero = 0;
		Scanner entrada = new Scanner(System.in);
		
		while (numero >= 0) {
		media += numero;
		contador++;
		System.out.println("Por favor introduce un numero: ");
		numero = entrada.nextInt();
		}
		entrada.close();	
		media /= contador;
		System.out.println("La media de los numeros introducidos es: "+media);
	}

}
