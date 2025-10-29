package boletin3ej6;

public class TareaLarga extends Thread{

	@Override
	public void run() {
		int contador = 0;
		
		while (!isInterrupted()) {
			System.out.print(contador + " ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				Thread.currentThread().interrupt();
			}
			contador++;
		}
		System.out.println("Hilo terminado.");
	}
	
	public static void main(String[] args) {
		/*Ejercicio 6: Terminación “graceful” y Verificación de isAlive()
		Objetivo: Practicar la terminación controlada (graceful) de un hilo usando
		isInterrupted() y la comprobación de estado con isAlive(). Es una técnica utilizada
		para detener la ejecución de un hilo de forma controlada y segura.
		En lugar de forzar la detención de un hilo de manera abrupta (como lo hacía el
		obsoleto método stop() ), la terminación graceful implica la cooperación del hilo
		que se desea detener.
		Enunciado:
		1. Crea una clase llamada TareaLarga que extienda de Thread.
		2. En el método run(), la lógica principal debe ejecutarse dentro de un bucle
		while (!isInterrupted()).
		3. Dentro del bucle, simula una tarea (por ejemplo, imprime un mensaje de
		progreso e incrementa un contador) y pausa brevemente (p. ej., 100 ms)
		usando sleep() (con su correspondiente try-catch que maneje la
		interrupción si ocurre).
		4. En el programa principal (main):
		o Crea y arranca la hebra de TareaLarga.
		o Usa un bucle while para comprobar repetidamente (p. ej., cada
		segundo) si el hilo sigue activo con el método isAlive()4. Mientras
		esté vivo, imprime el mensaje: "La tarea sigue en curso..."
		o Después de 5 segundos de espera total en el hilo principal, llama
		al método interrupt() sobre el hilo de TareaLarga.
		5. Verificación: El hilo principal debe seguir verificando con isAlive() hasta
		que el hilo de TareaLarga (al recibir la interrupción) salga de su bucle while
		(!isInterrupted()) y termine. El programa principal debe imprimir un
		mensaje de finalización solo después de que isAlive() devuelva false
		*/
		
		TareaLarga t = new TareaLarga();
		t.start();
		while(t.isAlive()) {
			System.out.println("\nLa tarea sigue en curso...");
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Hilo finalizado");

	}

}
