package ejerciciosSeleccion;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		/*Escribe un programa que pida por teclado un día de la semana en texto y que diga qué
		asignatura toca a primera hora ese día. Valida que se introduzca un valor válido para el día
		de la semana, en caso contrario mostrará “El día de la semana introducido no es correcto”.
		Para las cadenas de texto usaremos la clase String.*/
		
		int $dia;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un dia de la semana: ");
		$dia = entrada.nextInt();
		 if ($dia > 5 || $dia <= 0)
			 System.out.println("El dia introducido es incorrecto");
		 else if ($dia < 0)
			 System.out.println("El dia introducido es incorrecto");
		 else if ($dia == 1)
			 System.out.println("El lunes a primera toca redes");
		 else if ($dia == 2)
			 System.out.println("El martes a primera toca programacion");
		 else if ($dia == 3)
			 System.out.println("El miercoles a primera toca entornos");
		 else if ($dia == 4)
			 System.out.println("El jueves a primera toca marcas");
		 else if ($dia == 5)
			 System.out.println("El viernes a primera toca IPEI");
		entrada.close();
	}

}
