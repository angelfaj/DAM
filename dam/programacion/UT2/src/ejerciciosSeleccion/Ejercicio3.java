package ejerciciosSeleccion;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		/*Escribe un programa en que dado un número del 1 a 7 escriba el correspondiente nombre
		del día de la semana. Valida que se introduzca un número válido, en caso contrario escribe
		“El valor introducido es incorrecto”.*/
		
		int $dia;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un número del 1-7");
		$dia = entrada.nextInt();
		entrada.close();
		
		if (($dia > 7) || ($dia < 1)) {
			System.out.println("El número introducido es incorrecto");
		}
			else {
				switch ($dia) {
					case 1:
						System.out.println("Ese valor corresponde al Lunes");
						break;
					case 2:
						System.out.println("Ese valor corresponde al Martes");
						break;
					case 3:
						System.out.println("Ese valor corresponde al Miércoles");
						break;
					case 4:
						System.out.println("Ese valor corresponde al Jueves");
						break;
					case 5:
						System.out.println("Ese valor corresponde al Viernes");
						break;
					case 6:
						System.out.println("Ese valor corresponde al Sábado");
						break;
					case 7:
						System.out.println("Ese valor corresponde al Domingo");
						break;
				}
			}
		}
	}


