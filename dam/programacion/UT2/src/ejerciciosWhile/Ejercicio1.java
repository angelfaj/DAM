package ejerciciosWhile;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle while.
		
		int resul = 0, base = 5; 
		int contador = 1;
		
		while (resul < 100) {
			resul = base*contador;
			System.out.println(resul);
			contador++;
		}
	}

}
