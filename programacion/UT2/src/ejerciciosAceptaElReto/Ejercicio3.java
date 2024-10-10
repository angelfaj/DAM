package ejerciciosAceptaElReto;
import java.util.Scanner;


public class Ejercicio3 {

	public static void main(String[] args) {
		/*Para el entrenamiento de Luke Skywalker, Yoda ha planificado una serie de pruebas que deben realizarse. Las pruebas las puede realizar de manera simultánea.
		Para cada prueba, Yoda sabe cuantos días D faltan para que se pueda realizar por primera vez, y, a partir de ahí, cada cuantos días N dura la prueba. Por ejemplo, uno de los entrenamientos para la Prueba de la Percepción tiene D=5 y N=2, por lo que tardará 7.
		Sabiendo las pruebas a las que enfrentará a Luke, Yoda quiere saber cuantos días faltan para que finalice su última prueba.Cada caso de prueba comienza con una primera línea indicando el número P de pruebas que Luke tendrá que superar durante su entrenamiento.
		A continuación aparecen P líneas, cada una describiendo una prueba. Cada prueba se define con los dos números, 1 ≤ D,N ≤ 106, indicando cuantos días hay que esperar para poder empezarla y cuantos días tarda en hacer la prueba.
		La entrada de datos acaba con un 0.Por cada caso de prueba, el programa escribirá cuantos días faltan para que Luke finalice su última prueba. Se garantiza que tardará como mucho 106 días en terminar.
		
		¡¡¡¡¡basicamente pedimos un numero de pruebas, una vez introducidas cogemos la que sumando ambos numeros sea mayor que el resto, eso sera el resultado*/ 
		
		Scanner entrada = new Scanner(System.in);
		int numeroPruebas, dias, diasTarda, sumaDias, pruebaMayor;
		String resultadoFinal = "";
		final int FIN = 0;
		
		
		do {
			System.out.println("Introduce el numero de pruebas a realizar: ");
			numeroPruebas = entrada.nextInt();
			sumaDias= 0;
			pruebaMayor = sumaDias;
			
			for (int i = 0; i < numeroPruebas; i++) {
				
				System.out.printf("\nPrueba: ");
				dias = entrada.nextInt();
				diasTarda = entrada.nextInt();
				sumaDias= dias + diasTarda;
				
				if (sumaDias > pruebaMayor) {
					pruebaMayor = sumaDias;
				}
			}
			if (pruebaMayor != 0) {
				resultadoFinal += "\n" + pruebaMayor;	
			}

		} while (numeroPruebas != FIN);
		
		entrada.close();
		System.out.println("Resultado:" + resultadoFinal);
		
	}

}
