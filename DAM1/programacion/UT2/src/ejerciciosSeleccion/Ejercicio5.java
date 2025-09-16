package ejerciciosSeleccion;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		/*Realiza un programa que resuelva una ecuación de primer grado (del tipo ax + b = 0). Pide
		por teclado a y b para mostrar por pantalla la solución de x. Ten en cuenta que el valor de a
		no puede ser 0, en caso de serlo mostrará por pantalla “El valor de a no puede ser 0” y no
		se resolverá la ecuación.*/
		
		Scanner $entrada = new Scanner(System.in);
		int $a, $b, $x;
		
		System.out.println("Por favor introduce un valor para a: ");
		$a = $entrada.nextInt();
		if ( $a == 0 ) {
			System.out.println("El valor de a no puede ser 0");
		} else {
			System.out.println("Por favor introduce un valor para b: ");
			$b = $entrada.nextInt();
			$entrada.close();
			
			$x = -$b / $a;
			System.out.println("El valor de x es: "+ $x);
		}
	}

}
