package boletin1ej2y3;

public class LeerNombre {

	public static void main(String[] args) {
		/*Ejercicio 2
		Crea un programa Java llamado LeerNombre.java que reciba desde los argumentos de
		main() un nombre y lo visualice en pantalla. Utiliza System.exit(1) para una finalización
		correcta del programa y System.exit(2) para el caso que no se hayan introducido
		argumentos en main()
		*/
		
		if (args.length == 0) {
			System.out.println("No se ha introducido ningun argumento");
			System.exit(2);
		}else {
			System.out.println("El nombre introducido es: " + args[0]);
			System.exit(1);
		}

	}

}
