package boletin4ej1;

public class Main {

	public static void main(String[] args) {
		/*EJERCICIO 01
		Se le pasan dos números al programa principal, después se crean dos hilos, uno que sume los
		números pasados por argumento y lo guarde en una variable estática de la clase MiHilo y otro
		hilo que reste los números y lo guarde en esa misma variable estática de la clase MiHilo. Al
		finalizar cada hilo debe mostrar por pantalla el resultado que ha realizado cada uno sin que se
		vea afectada por operación que ha hecho el otro hilo sobre la variable estática.
		Nota: usa la interfaz Runnable para los hilos.
		*/
		Cuenta c = new Cuenta();
		HiloSuma h1 = new HiloSuma(3, 4, c);
		HiloResta h2 = new HiloResta(3, 4, c);
		Thread hilo1 = new Thread(h1);
		Thread hilo2 = new Thread(h2);
		
		hilo1.start();
		hilo2.start();
	}

}
