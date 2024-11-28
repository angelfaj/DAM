package ejerciciosArraysI;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Hacer un programa que almacene en un vector de 5 elementos las ventas anuales de cada una
		de las 5 tiendas de una cadena de supermercados (asignárselos al vector al declararlo). A
		continuación calcular cuál fue la tienda que menos vendió, cuál fue la que más vendió y el
		importe total de ventas de las 5 tiendas.
		
		double ventas[] = {500056.34, 306578.43, 566666.78, 306578.43, 566666.78};
		double mayor = ventas[0], menor = ventas [0], suma = 0;
		
		for (int i = 0; i < ventas.length; i++) {
		
			if (ventas[i] < menor) {
				menor = ventas[i];
			}
			if (ventas[i] > mayor) {
				mayor = ventas[i];
			}
			suma += ventas[i];
		}
		
		System.out.println("La tienda que menos vendio fue: " + menor);
		System.out.println("La tienda que mas vendio fue: " + mayor);
		System.out.println("La suma total de las ventas es: " + suma);
		 */

		
		/*Almacenar en un vector 5 numeros enteros leidos por teclado. Leer a continuación otro
		número y comprobar si está en el vector o no. En el caso de que esté visualizar que posición
		ocupa; sino indicarlo mediante un mensaje. Visualizar tambien el elemento más pequeño, el
		más grande y la posición de ambos.*/
		
		Scanner entrada = new Scanner(System.in);
		int numeros[] = new int[5], ultimoNumero = -1; 
		boolean vuelta = false, flag = false;							//flag sirve para saber si ha encontrado coincidencia con el ultimo numero
		int mayor = numeros[0], menor = 1000000000, posMenor = 0, posMayor = -1;
		String mensaje = "";
		
		for (int i = 0; i < numeros.length; i++) {
			int posicion = i;
			
			if (vuelta == false) {										//Evitamos que en el segundo ciclo entre de nuevo
				System.out.println("Introduce un numero: ");
				numeros[i] = entrada.nextInt();
				
				if (numeros[i] < menor) {
					menor = numeros[i];
					posMenor = i;
				}
				if (numeros[i] > mayor) {
					mayor = numeros[i];
					posMayor = i;
				}
			}
			
			if (ultimoNumero == numeros[i]) {							//Aqui guardamos la posicion en caso de encontrarlo
				mensaje = "El numero " + ultimoNumero + " ya se encuentra en el vector en la posición " + posicion;
				flag = true;
			}
			
			if ((i == (numeros.length - 1)) && (vuelta == false)){			//Entra aqui al teerminar la primera ejecucion del for y lo reinicia
				System.out.println("Introduce el ULTIMO numero: ");
				ultimoNumero = entrada.nextInt();
				i = -1;
				vuelta = true;
			}
		}
		entrada.close();
		
		if (flag == false) {
			mensaje = "El numero " + ultimoNumero + " NO se encuentra en el vector";
		}
		mensaje += "\n" + "El menor de los elementos es: " + menor + " y su posicion es " + posMenor + ", el mayor de los elementos es: " + mayor + " y su posicion " + posMayor;
		System.out.println(mensaje);
		
		
		
		
		
	}

}
