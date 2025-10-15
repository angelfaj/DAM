package e2y3y4;

public class LeerNombre {

	public static void main(String[] args) {
		/*Ejercicio 2
		Crea un programa Java llamado LeerNombre.java que reciba desde los argumentos de
		main() un nombre y lo visualice en pantalla. Utiliza System.exit(1) para una finalización
		correcta del programa y System.exit(2) para el caso que no se hayan introducido
		argumentos en main().
		Ejercicio 3
		Haz un programa que ejecute el Ejercicio 2 LeerNombre.java. Utiliza el método
		waitFor() para comprobar el valor de salida del proceso que se ejecuta. Prueba la
		ejecución del programa dando valor a los argumentos del main() y sin darle valor.
		¿Qué valor devuelve waitFor() en un caso y en otro?
		Ejercicio 4
		Partiendo del ejercicio 3, muestra por pantalla los errores que se producen al ejecutar
		un programa Java que no exista.
		*/
		
		if (args.length < 1) {
			System.out.println("Debes introduir argumentos");
			System.exit(2);
		}else {
			System.out.println("Nombre recibido: " + args[0]);
			System.exit(1);
		}

	}

}
