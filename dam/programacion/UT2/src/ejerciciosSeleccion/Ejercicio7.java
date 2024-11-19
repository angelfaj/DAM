package ejerciciosSeleccion;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		/*Realiza un programa que calcule la media de tres notas que se pida por teclado. Muestra el
		resultado con 1 decimal que diga la nota del boletín (insuficiente, suficiente, bien,
		notable o sobresaliente).*/
		
		double $nota1, $nota2, $nota3, $media;
		Scanner $entrada = new Scanner(System.in);
		
		
		System.out.println("Introduce la 1º nota: ");
		$nota1 = $entrada.nextDouble();
		System.out.println("Introduce la 2º nota: ");
		$nota2 = $entrada.nextDouble();
		System.out.println("Introduce la 3º nota: ");
		$nota3 = $entrada.nextDouble();
		$entrada.close();
		if (($nota1 < 0) || ($nota1 > 10) || ($nota2 < 0) || ($nota2 > 10) || ($nota3 < 0) || ($nota3 > 10)) {
			System.out.println("Todas las notas deben estar comprendidas entre 0 y 10");
		} else {
			$media = ($nota1 + $nota2 + $nota3)/3;
			
			if ($media < 5) {
				System.out.printf("Tu media es: %.1f", $media, " ¡Insuficiente!");
			} else if (($media >= 5) && ($media < 6)) {
				System.out.printf("Tu media es: %.1f", $media, " ¡Suficiente!");
			} else if ($media == 6) {
				System.out.printf("Tu media es: %.1f", $media, " ¡Bien!");
			} else if (($media >= 7) && ($media < 10)) {
				System.out.printf("Tu media es: %.1f", $media, " ¡Notable!");
			} else if ($media == 10) {
				System.out.printf("Tu media es: %.1f", $media, " ¡Sobresaliente!");
			}

		}
		
		
	}

}
