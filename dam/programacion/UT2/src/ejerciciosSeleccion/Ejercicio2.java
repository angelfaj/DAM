package ejerciciosSeleccion;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*Realiza un programa que pida una hora por teclado y que muestre luego buenos días,
		buenas tardes o buenas noches según la hora. Se utilizarán los tramos de 6 a 12, de 13 a
		20 y de 21 a 5. respectivamente. Sólo se tienen en cuenta las horas, los minutos no se
		deben introducir por teclado. Comprueba también que se haya metido un número válido, en
		caso contrario mostrará por pantalla “El valor introducido no es válido”.*/
		
		int $hora;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Por favor introduce una hora: ");
		$hora = entrada.nextInt();
		entrada.close();
		if ($hora >= 6 && $hora <= 12)
			System.out.println("Buenos días por la mañana crack");
		else if ($hora >= 13 && $hora <= 20)
			System.out.println("Buenas tardes!");
		else if (($hora >= 21 && $hora <= 24) || ($hora >= 0 && $hora <= 5))
			System.out.println("Buenas noches");
		else System.out.println("La hora introducida es incorrecta, try again :D");	
	}

}
