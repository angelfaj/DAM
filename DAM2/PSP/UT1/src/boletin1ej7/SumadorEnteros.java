package boletin1ej7;

public class SumadorEnteros {

	public static void main(String[] args) {
		/*Ejercicio 7
		Escribe un programa Java que lea dos números pasados como argumentos desde
		main() y visualice la suma de ese rango de números, finaliza el programa con
		System.exit valor 0. Controlar que lo introducido sean dos números, si alguno no lo es,
		termina el programa con System.exit() valor 1.
		Haz otro programa Java para ejecutar el anterior con dos procesos. Cada proceso
		dejará en un fichero el resultado de su suma y el programa principal sumará el
		contenido de los dos resultados para mostrarlos por pantalla.
		*/
		
		try {
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			int resul = n1;
			
			while (n1 < n2) {
				n1++;
				resul += n1;
			}
			System.out.println(resul);
			System.exit(0);
		}catch (NumberFormatException e) {
			System.exit(1);
		}

	}

}
