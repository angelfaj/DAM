package ejerciciosAceptaElReto;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*La entrada comenzará con un entero que indica el número de casos de prueba. Cada uno de ellos está formado por dos líneas; la primera indica el titular donde buscar un mensaje oculto y la segunda indica el mensaje a buscar. La longitud de cada una de las cadenas no excederá los 2000 caracteres. Ten en cuenta que no hace falta distinguir entre mayúsculas y minúsculas y que los espacios del mensaje oculto no son relevantes, es decir, no hace falta que existan en el mensaje original, pero sí deben aparecer el resto de caracteres (signos de puntuación, comillas, etc.). Se garantiza que el mensaje oculto a buscar no empieza ni termina por espacios.
		La entrada contendrá únicamente letras del alfabeto inglés, por lo que no aparecerán vocales con tilde. Además, podrían aparecer múltiples espacios consecutivos. Para cada caso de prueba el programa escribirá SI si el mensaje buscado aparece en el titular y NO en caso contrario.*/
		Scanner entrada = new Scanner(System.in);
		int numeroCasos, centinela, centinelaAnterior;
		char valorBusqueda;
		boolean esBueno, esMalo;
		String titular, mensaje, casos = "";
		
		
		System.out.printf("Introduce el numero de casos a evaluar: ");
		numeroCasos = entrada.nextInt();
		entrada.nextLine();
		
		for (int contador = 0; contador < numeroCasos; contador++) {																	//Bucle principal
			System.out.printf("%nTitular: ");
			titular = entrada.nextLine();
			
			System.out.printf("%nMensaje: ");
			mensaje = entrada.nextLine();
			
			int longitudMensaje = mensaje.length();				
			centinela = 0;
			centinelaAnterior = 0;
			esBueno = false;
			esMalo = false;
			
			for (int contadorLongitudMensaje = 0; contadorLongitudMensaje < longitudMensaje; contadorLongitudMensaje++) {				//Bucle de busqueda
				valorBusqueda = mensaje.charAt(contadorLongitudMensaje);
				centinela = titular.indexOf(valorBusqueda);
				
				if ((centinela >= 0) && (centinela >= centinelaAnterior)) {
					esBueno = true;
				} else {
					esMalo = true;
				}

				centinelaAnterior = centinela;
			}
			
			if (esMalo) {
				casos += "CASO " + contador + " NO" + "\n";			//Guardo el caso con su resultado tras evaluarlo				
			} else {
				casos += "CASO " + contador + " SI" + "\n";			//Guardo el caso con su resultado tras evaluarlo
			}
		}

		System.out.println("\n"+casos);

	}

}
//GG EZ
