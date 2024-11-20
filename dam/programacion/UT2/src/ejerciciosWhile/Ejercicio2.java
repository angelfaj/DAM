package ejerciciosWhile;

public class Ejercicio2 {

	public static void main(String[] args) {
		//Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás utilizando un bucle
		//while.
		
		int resto = 20, top = 320, bottom = 160;
		
		System.out.println(top);
		while (top != bottom) {
			top -= resto;
			System.out.println(top);
		}
	}

}
