package interrupciones;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 1: Contador interrumpible
		Objetivo: Practicar interrupt() y isInterrupted(). Control elegante de fin del hilo
		sin stop().
		Enunciado:
		Crear una clase Contador que implemente Runnable.
		El hilo debe contar desde 1 hasta infinito, mostrando el valor cada 500 ms.
		Desde el main, iniciar el hilo, esperar 3 segundos e interrumpirlo.
		El hilo debe detectar la interrupción (usando isInterrupted() o capturando
		InterruptedException) y terminar mostrando un mensaje de despedida.*/

//		Thread contador = new Thread(new HiloContador());
//		contador.start();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		contador.interrupt();
		
		/*Ejercicio 4: Contador activo con interrupción manual
		Objetivo: Detectar interrupciones en un hilo que no está bloqueado
		(isInterrupted() sin sleep).
		Enunciado:
		Crea una clase ContadorActivo que extienda Thread. En su método run(), debe
		contar del 1 al 1.000. En cada iteración, comprueba si el hilo ha sido interrumpido
		usando isInterrupted(). Si lo ha sido, muestra un mensaje y termina el bucle.
		Desde el main(), lanza el hilo y, tras 1 segundo, llama a interrupt().Usa
		System.currentTimeMillis() para mostrar cuánto tiempo estuvo activo y
		muestra también cuántos números logró contar antes de ser interrumpido.
		Pistas:
		• No usar sleep() ni try-catch.
		Reto extra: Añadir una segunda variable pararManual que permita detener el
		hilo sin usar interrupt(), para comparar ambos enfoques.*/
		
		ContadorActivo c1 = new ContadorActivo();
		c1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		c1.interrupt();
		c1.pararHilo();
		System.out.println("Tiempo total de ejecucion: " + System.currentTimeMillis() + " milisegundos");
		
		
	}
}
