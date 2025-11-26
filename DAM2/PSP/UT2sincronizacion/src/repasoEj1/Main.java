package repasoEj1;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 1: simulación de barrera “Sincronización por fases entre hilos”
		Se desea simular un proceso compuesto por tres fases (por ejemplo,
		Preparar, Ejecutar y Finalizar), en el que varios hilos trabajan en paralelo, pero
		ningún hilo puede pasar a la siguiente fase hasta que todos los demás
		hayan terminado la actual.
		Ayuda para desarrollo:
		1. Crea una clase llamada Coordinador que controle el avance de las fases.
		o Esta clase debe mantener cuántos hilos han terminado una fase.
		o Cuando todos los hilos terminen una fase, debe reiniciar el
		contador y despertar a todos los hilos para que pasen a la
		siguiente.
		2. Crea una clase Tarea que implemente Runnable.
		o Cada hilo simulará el trabajo de tres fases:
		▪ Preparar
		▪ Ejecutar
		▪ Finalizar
		3. Entre fases, cada hilo debe esperar usando los métodos del Coordinador.
		4. Simula el trabajo de cada fase con Thread.sleep(1000) o similar.
		5. En el main, lanza tres hilos que trabajen con el mismo Coordinador.
		Observa cómo todos los hilos esperan unos por otros al final de cada fase.
		Ejemplo ejecución:
		Hilo-1 preparando...
		Hilo-2 preparando...
		Hilo-3 preparando...
		Hilo-2 ha terminado la fase: Preparar
		Hilo-3 ha terminado la fase: Preparar
		Hilo-1 ha terminado la fase: Preparar
		---- Todos los hilos han completado la fase Preparar ----
		Hilo-1 ejecutando...
		Hilo-3 ejecutando...
		Hilo-2 ejecutando...
		Hilo-3 ha terminado la fase: Ejecutar
		Hilo-2 ha terminado la fase: Ejecutar
		Hilo-1 ha terminado la fase: Ejecutar
		---- Todos los hilos han completado la fase Ejecutar ----
		Hilo-1 finalizando...
		Hilo-3 finalizando...
		Hilo-2 finalizando...
		Hilo-2 ha terminado la fase: Finalizar
		Hilo-1 ha terminado la fase: Finalizar
		Hilo-3 ha terminado la fase: Finalizar
		---- Todos los hilos han completado la fase Finalizar ----
		…
		Ayuda explicación código:
		1. Fase “Preparar”:
		o Los tres hilos comienzan casi al mismo tiempo.
		o Cada uno anuncia “preparando…” y luego termina su fase.
		o Los dos primeros hilos hacen wait() y el último (cuando los tres
		terminan) hace notifyAll(), despertando a los otros.
		2. Fase “Ejecutar”:
		o Todos avanzan sincronizadamente, como un equipo que no pasa
		al siguiente paso hasta que todos están listos.
		3. Fase “Finalizar”:
		o Igual dinámica: todos finalizan juntos, y el Coordinador indica
		cuándo se ha completado la fase.*/
		
		Coordinador c = new Coordinador();
		
		Thread h1 = new Thread(new HiloFases("H1", c));
		Thread h2 = new Thread(new HiloFases("H2", c));
		Thread h3 = new Thread(new HiloFases("H3", c));
		
		h1.start();
		h2.start();
		h3.start();

	}

}
