package ejerciciosAceptaElReto;
import java.util.Scanner;


public class Ejercicio3 {

	public static void main(String[] args) {
		/*Para el entrenamiento de Luke Skywalker, Yoda ha planificado una serie de pruebas que deben realizarse por orden. Cada una requiere un día completo de dedicación por parte de su joven aprendiz.
		Por desgracia, las pruebas no pueden realizarse en cualquier momento, porque dependen de las condiciones del entorno y, en ocasiones, de alineaciones planetarias. Para cada una, Yoda sabe cuantos días D faltan para que se pueda realizar por primera vez, y, a partir de ahí, cada cuantos días N puede volver a hacerse. Por ejemplo, uno de los entrenamientos para la Prueba de la Percepción tiene D=5 y N=2, por lo que podrá hacerse dentro de 5 días, o dentro de 7, o dentro de 9…
		Sabiendo las pruebas a las que enfrentará a Luke, Yoda quiere saber cuantos días faltan para que haga su última prueba.Cada caso de prueba comienza con una primera línea indicando el número P de pruebas que Luke tendrá que superar durante su entrenamiento.
		A continuación aparecen P líneas, cada una describiendo una prueba en el orden en el que Luke debe realizarlas. Cada prueba se define con los dos números, 1 ≤ D,N ≤ 106, indicando cuantos días hay que esperar para poder realizarla por primera vez, y cada cuantos días se puede hacer a partir de ese momento.
		La entrada de datos acaba con un 0.Por cada caso de prueba, el programa escribirá cuantos días faltan para que Luke haga su última prueba. Se garantiza que tardará como mucho 106 días en terminar.
		
		D = dias restantes para hacer prueba x 1º vez
		N = dias restantes para repetirla
		P = nº introducido x teclado que indica el nº de pruebas a realizar
		P = 0 fin de la recogida de datos
		¡¡¡¡¡basicamente pedimos un numero de pruebas, una vez introducidas cogemos la que sumando ambos numeros sea mayor que el resto, eso sera el resultado*/ 
		
		Scanner entrada = new Scanner(System.in);
		int numeroPruebas, dias, diasTarda, resultado = 0, resultadoComodin = resultado;
		String resultadoFinal = "";
		final int FIN = 0;
		
		
		do {
			System.out.println("Introduce el numero de pruebas a realizar: ");
			numeroPruebas = entrada.nextInt();
			for (int i = 0; i < numeroPruebas; i++) {
				
				System.out.printf("\nPrueba: ");
				dias = entrada.nextInt();
				diasTarda = entrada.nextInt();
				resultado = dias + diasTarda;
				
				if (resultado <= resultadoComodin) {
					resultado = resultadoComodin;
				}
				
				resultadoComodin = resultado;
				resultadoFinal += "\n" + resultado;
				
			}
		} while (numeroPruebas != FIN);
		
		System.out.println("Resultado:" + resultadoFinal);
		
	}

}
