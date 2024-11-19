package ejerciciosWhile;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		/*Escribe un programa que obtenga los números enteros comprendidos entre dos números
		introducidos por teclado y validados como distintos, el programa debe empezar por el menor
		de los enteros introducidos e ir incrementando de 7 en 7.*/
		
		int numero1, numero2, incremento = 7;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Por favor introduce un valor entero: ");
		numero1 = entrada.nextInt();
		
		System.out.println("Por favor introduce otro valor entero: ");
		numero2 = entrada.nextInt();
		entrada.close();
		
	
		if (numero1 != numero2) {	
			if (numero1 > numero2) {		//Comodin nos ayuda a comenzar por el menor
				int comodin = numero1;
				numero1 = numero2;
				numero2= comodin;
			}
			while ((numero2 > numero1) && (numero1 + incremento) < numero2) {
				numero1 += incremento;
				System.out.println(numero1);
			}
		} else {
			System.out.println("Los numeros introducidos no pueden ser iguales");
		}
	}
}

