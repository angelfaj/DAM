package boletin4ej2;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 02
		Crea un programa que muestre la sincronización al controlar del acceso a un método
		llamado sumArray, que suma los elementos de una matriz de enteros. Para ello, en el
		programa principal se crearán dos hilos a los cuales se les pasará el mismo array de
		enteros. Por ejemplo, int a[]={1,2,3,4,5}; Este array debe ser estático en la clase de mi
		hilo, pues será compartido a nivel de clase (no de objeto). Después cada hilo iniciará la
		suma del array de manera paralela pero sin mezclarse los resultados parciales que tenga
		la suma de cada hilo (utiliza synchronized para ello). Este método se llama sumArray y
		tendrá como parámetro de entrada el array de enteros a sumar y como resultado la
		suma. Cuando el hilo finalice, devolverá el resultado que le ha dado al realizar la suma.
		Prueba a poner a no utilizar synchronized y comprueba los resultados, ¿qué sucede?
		Nota: usa la interfaz Runnable para los hilos
		*/
		ResultadoSuma resultado = new ResultadoSuma();
		int[] arraySuma = {1, 2, 3, 4, 5};
		Thread hilo1 = new Thread(new HiloSumador("H1", arraySuma, resultado));
		Thread hilo2 = new Thread(new HiloSumador("H2", arraySuma, resultado));
		
		hilo1.start();
		hilo2.start();
	}

}
