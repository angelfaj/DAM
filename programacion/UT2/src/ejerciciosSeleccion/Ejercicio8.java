package ejerciciosSeleccion;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		/*Escribe un programa que nos diga el horóscopo a partir del día y el mes de nacimiento que
		el usuario introduzca por teclado. En caso de no introducir un día y mes válido, se mostrará
		el mensaje siguiente “Se ha producido un error, comprueba que los datos introducidos son
		correctos”. Puedes ver en el siguiente enlace las fechas de cada signo del zodiaco:
			SIGNOS DEL ZODIACO:
			 * ARIES: 21/3 - 20/4
			 * TAURO: 21/4 - 20/5
			 * GEMINIS: 21/5 - 20/6
			 * CANCER: 21/6 - 20/7
			 * LEO: 21/7 - 21/8
			 * VIRGO: 22/8 - 22/9
			 * LIBRA: 23/9 - 22/10
			 * ESCORPIO: 23/10 - 22/11 
			 * SAGITARIO: 23/11 - 20/12
			 * CAPRICORNIO: 21/12 - 19/1
			 * ACUARIO: 20/1 - 18/2
			 * PISCIS: 19/2 - 20/3*/
			
		int $dia;
		String mes, signo;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Por favor introduce tu mes de nacimiento");
		mes = entrada.nextLine();
		System.out.println("Por favor introduce tu día de nacimiento");
		$dia = entrada.nextInt();
		entrada.close();
		
		if (($dia > 31) || ($dia < 1)) {
			System.out.println("Por favor introduce un dia válido");
		} else {
			switch (mes) {
			case "enero":
				if ($dia <= 19) {
					System.out.println("¡Eres Capricornio!");
				} else {
					System.out.println("¡Eres Acuario!");
				}
				break;
			case "febrero":
				if ($dia >= 19) {
					System.out.println("¡Eres Acuario!");
				} else {
					System.out.println("¡Eres Piscis!");
				}
				break;
			case "marzo":
				if ($dia >= 21) {
					System.out.println("¡Eres Aries!");
				} else {
					System.out.println("¡Eres Piscis!");
				}
				break;
			case "abril":
				if ($dia >= 21) {
					System.out.println("¡Eres Tauro!");
				} else {
					System.out.println("¡Eres Aries!");
				}
				break;
			case "mayo":
				if ($dia >= 21) {
					System.out.println("¡Eres Geminis!");
				} else {
					System.out.println("¡Eres Tauro!");
				}
				break;
			case "junio":
				if ($dia >= 21) {
					System.out.println("¡Eres Cancer!");
				} else {
					System.out.println("¡Eres Geminis!");
				}
				break;
			case "julio":
				if ($dia >= 21) {
					System.out.println("¡Eres Leo!");
				} else {
					System.out.println("¡Eres Cancer!");
				}
				break;
			case "agosto":
				if ($dia >= 22) {
					System.out.println("¡Eres Virgo!");
				} else {
					System.out.println("¡Eres Leo!");
				}
				break;
			case "septiembre":
				if ($dia >= 23) {
					System.out.println("¡Eres Libra!");
				} else {
					System.out.println("¡Eres Virgo!");
				}
				break;
			case "octubre":
				if ($dia >= 23) {
					System.out.println("¡Eres Escorpio!");
				} else {
					System.out.println("¡Eres Libra!");
				}
				break;
			case "noviembre":
				if ($dia >= 23) {
					System.out.println("¡Eres Sagitario!");
				} else {
					System.out.println("¡Eres Escorpio!");
				}
				break;
			case "diciembre":
				if ($dia >= 21) {
					System.out.println("¡Eres Capricornio!");
				} else {
					System.out.println("¡Eres Sagitario!");
				}
				break;
			default:
				System.out.println("Por favor introduce un mes válido");
			}
		}
		
	}

}
