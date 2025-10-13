package boletin1ej5;

public class FlujoErrores {

	public static void main(String[] args) {
		/*Ejercicio 5
		Realiza un programa Java que admita argumentos desde main() y devuelva con
		System.exit() los siguientes valores:
		• Si el número de argumentos es < 1 debe devolver 1.
		• Si recibe un argumento y el argumento es una cadena debe devolver 2.
		• Si recibe un argumento y el argumento es un número entero menor que 0 debe
		devolver 3.
		• Si recibe un argumento y el argumento es un número entero mayor que 0 debe
		devolver 4.
		• En cualquier otra situación debe devolver 0.
		Realiza un segundo programa Java que ejecute al anterior. Este segundo programa
		deberá mostrar en pantalla lo que pasa dependiendo del valor devuelto al ejecutar el
		programa anterior.
		*/
		
		if (args.length < 1 ) {
			System.exit(1);
		}else if (args.length == 1) {
			try {
				if (Integer.parseInt(args[0]) < 0) {
					System.exit(3);
				}else if (Integer.parseInt(args[0]) > 0) {
					System.exit(4);
				}
			}catch (NumberFormatException e) {
				String aux = "";
				if (args[0].getClass().equals(aux.getClass())) {
					System.exit(2);
				}
			}
		}else {
			System.exit(0);
		}
	}
}
