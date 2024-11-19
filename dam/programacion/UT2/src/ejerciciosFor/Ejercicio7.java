package ejerciciosFor;

public class Ejercicio7 {

	public static void main(String[] args) {
		/*Muestra por pantalla todos los números primos entre 2 y 100, ambos incluidos. Pista: usa
		while y for.*/
		int numeroInf = 2, numeroSup = 100, primo;
		
		while (numeroInf <= 100) {
			for (;numeroInf <= 100; numeroInf++) {
				primo = (numeroInf%(numeroInf - 1));
				if (primo == 0) {
					System.out.println("Entre el 2 y el 100 esta el: "+numeroInf);
				}
				
			}

			numeroInf++;
		}
		
		
	}

}
