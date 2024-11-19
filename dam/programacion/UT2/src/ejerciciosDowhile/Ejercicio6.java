package ejerciciosDowhile;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		/*Escribe un programa que muestre en tres columnas, el cuadrado y el cubo de los 5 primeros
		números enteros a partir de uno que se introduce por teclado.*/
		
		int numero = 0, contador = 0;
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf("Por favor introduce un número: ");
		numero = entrada.nextInt();
		
		
		 do {
			 int cuadrado = numero*numero;
			 int cubo = numero*numero*numero;
			 System.out.printf(numero+"\t"+cuadrado+"\t"+cubo+"\n");
			 contador++;
			 numero++;
			 
		 } while (contador < 5);

}
}