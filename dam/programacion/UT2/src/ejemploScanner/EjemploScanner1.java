package ejemploScanner;

import java.util.Scanner;

public class EjemploScanner1 {

	public static void main(String[] args) {
		//Solicitar varias entradas y mostrarlas concatenadas
		Scanner entrada = new Scanner(System.in);
		
		String $nombre, $apellido, $respuesta;
		int $edad;
		
		System.out.println("Introduce tu nombre: ");
		$nombre = entrada.nextLine();

		System.out.println("Introduce tu apellido: ");
		$apellido = entrada.nextLine();

		System.out.println("Introduce tu edad: ");
		$edad = entrada.nextInt();
		
		System.out.println("Hola "+$nombre+" "+$apellido+", tu edad son "+$edad+" años");
			
	}

}
