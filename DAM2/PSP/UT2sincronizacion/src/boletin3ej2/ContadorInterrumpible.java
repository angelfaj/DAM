package boletin3ej2;

public class ContadorInterrumpible extends Thread {

	@Override
	public void run() {
		String mensajeFinal = "El hilo terminó naturalmente";
		try {
			for (int i = 0; i <= 100; i++) {
				System.out.print(i + " ");
					Thread.sleep(200);
				}
			System.out.println(mensajeFinal);
		} catch (InterruptedException e) {
			System.out.println("el hilo fue interrumpido");
			mensajeFinal = "El hilo fue interrumpido.";
		}
	}	
	
	public static void main(String[] args) {
		/*Ejercicio 2: Contador interrumpible con interrupt()
		Objetivo: Comprender cómo interrumpir un hilo que está en sleep().
		Enunciado:
		Crea una clase ContadorInterrumpible que extienda Thread. En su método run(),
		debe contar del 1 al 100, mostrando cada número con una pausa de 200 ms
		(sleep). Desde el main(), lanza el hilo y, tras 2 segundos, interrúmpelo con
		interrupt(). Captura la excepción InterruptedException y muestra un mensaje
		indicando que el hilo fue interrumpido.
		Reto extra: Añadir un mensaje final que indique si el hilo terminó normalmente
		o fue interrumpido.
		*/
		
		ContadorInterrumpible c = new ContadorInterrumpible();
		c.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.interrupt();

	}

}
