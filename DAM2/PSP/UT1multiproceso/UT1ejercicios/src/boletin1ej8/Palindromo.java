package boletin1ej8;

public class Palindromo {

	public static void main(String[] args) {
		/*
		Ejercicio 8
		a) Realiza un programa Java que lea una cadena pasada como argumento al
		main() y visualice en pantalla si la cadena es o no palíndromo (palabra o
		expresión que es igual si se lee de izquierda a derecha que de derecha a
		izquierda) o si la cadena está vacía (la longitud es 0). Si termina ok el programa
		termina con 0 y si no se han introducido parámetros termina con 1.
		b) Realiza un segundo programa Java que ejecute el anterior, para ello considera
		lo siguiente:
		• Desde el proceso principal nuevo se ejecutará un fichero inputEj08.txt
		que contenga en cada línea una palabra para ser revisada si es o no
		palíndromo. La información (el contenido) de este fichero de entrada
		inputEj08.txt se debe volcar en otro de salida salida08.txt mediante la
		ejecución del comando cat usando el ProcessBuilder de la clase actual.
		• Ese fichero de salida, salida08.txt, debe ser leído línea a línea y por cada
		línea se debe mandar ejecutar un nuevo proceso que lance la clase
		creada en el apartado a) La salida de esta ejecución debe mostrarse por
		pantalla. Antes de empezar a leer dale un tiempo a que termine de ser
		escrito el fichero salida08.txt, para ello usa la siguiente línea de código
		Thread.sleep(5000);
		*/
		
		if (args.length < 1 || args.length > 1) {
			System.out.println("Este programa solo admite un argumeno");
			System.exit(1);
		}else {
			String cadena = args[0];
			boolean palindromo = true;
			int j = cadena.length();
			
			for (int i = 0; i < cadena.length(); i++) {
				j--;
				if (!(cadena.charAt(i) == cadena.charAt(j))) {
					palindromo = false;
				}
			}
			String esPalindromo;
			if (palindromo) {
				esPalindromo = " SI ";
			}else {
				esPalindromo = " NO ";
			}
			System.out.println("La palabra '" + cadena + "'" + esPalindromo + "es un palíndromo");
			System.exit(0);
		}
		

	}

}
