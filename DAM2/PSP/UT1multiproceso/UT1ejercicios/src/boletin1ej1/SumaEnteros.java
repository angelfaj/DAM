package boletin1ej1;

public class SumaEnteros {

	public static void main(String[] args) {
		/*
		Ejercicio 1
		Crea un programa que reciba dos números enteros en el main() y sume todo el
		intervalo que hay entre ellos. El resultado muéstralo por pantalla.
		Después crea otro programa que ejecute el anterior y muestre el resultado por
		pantalla.
		*/
		int menor = Integer.parseInt(args[0]), mayor = Integer.parseInt(args[1]);
		int resul;
		
		if (menor > mayor) {
			int aux = menor;
			menor = mayor;
			mayor = aux;
		}
		
		resul = menor;
		int menorOriginal = menor;
		while (menor < mayor) {
			menor++; 
			resul += menor;
		}
		System.out.println("Numeros introducidos " + menorOriginal + " y " + mayor + ", resultado: " + resul);
	}

}
