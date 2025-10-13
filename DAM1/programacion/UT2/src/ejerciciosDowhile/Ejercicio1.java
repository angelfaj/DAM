package ejerciciosDowhile;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle do-while.
		int numero = 5, contador = 0;
		
		do {
			System.out.println(contador);
			contador +=5 ;
		} while ((contador >= 0) && (contador <= 100));
		
	}

}
