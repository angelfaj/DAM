package boletin3ej3;

public class ContadorRapido extends Thread{

	@Override
	public void run() {
		int i = 0;
		
		while (i <= 100000 && !isInterrupted()) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println("\nHilo terminado con i = " + (i - 1));
	}
	
	public static void main(String[] args) {
		/*Ejercicio 3: Interrupción controlada con isInterrupted()
		Objetivo: Usar isInterrupted() para terminar un hilo sin usar sleep().
		Enunciado:
		Crea una clase ContadorRapido que cuenta del 1 al 1000 sin pausas. En cada
		iteración, comprueba si ha sido interrumpido con isInterrupted(). Desde el main(),
		lanza el hilo y, tras 1 segundo, interrúmpelo. El hilo debe terminar limpiamente si
		detecta la interrupción.
		Reto extra: Añadir un mensaje que indique cuántos números logró contar antes
		de ser interrumpido.
		*/
		
		ContadorRapido c = new ContadorRapido();
		c.start();
		try {
			Thread.sleep(70);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.interrupt();

	}

}
