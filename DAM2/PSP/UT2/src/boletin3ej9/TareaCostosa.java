package boletin3ej9;

public class TareaCostosa extends Thread {
	private String nombre;
	private int tiempoEjecucion;

	public TareaCostosa (String nombre, int tiempoEjecucion) {
		super(nombre);
		this.tiempoEjecucion = tiempoEjecucion;
	}
	
	@Override
	public void run() {
		try {
			sleep(tiempoEjecucion);
		} catch (InterruptedException e) {
			System.out.println("Tarea " + getName() + " cancelada por interrupcion");
		}
	}
	
	public static void main(String[] args) {
		/*Ejercicio 9:
		Cancelación Condicional con join(long timeout) e interrupt()
		Objetivo: Combinar el join() con tiempo límite, interrupt() y isAlive() para
		implementar una política de cancelación por exceder un tiempo de espera.
		Descripción:
		1. Crea una clase TareaCostosa que extienda de Thread. Su constructor
		acepta un tiempo de ejecución simulado ($T_{sim}$ en milisegundos).
		2. En run(), el hilo duerme por el tiempo $T_{sim}$. Dentro del try-catch del
		sleep(), si se recibe una InterruptedException, imprime "Tarea [nombre]
		cancelada por interrupción.".
		3. En la clase principal (main):
		o Define un tiempo límite de 3000 ms (3 segundos).
		o Crea una instancia de TareaCostosa con un tiempo simulado de
		5000 ms (5 segundos) (es decir, más largo que el límite).
		o Arranca el hilo.
		o Llama a join() sobre el hilo de la tarea costosa, especificando el
		tiempo límite: hiloTarea.join(3000).
		o Inmediatamente después de la llamada a join(), el hilo principal
		debe:
		▪ Usar if (hiloTarea.isAlive()) para verificar si el hilo no
		terminó a tiempo.
		▪ Si sigue vivo, imprime "Tiempo límite excedido. Cancelando
		tarea..." y llama a hiloTarea.interrupt().
		▪ Si no está vivo, imprime "Tarea finalizada dentro del tiempo
		límite.".
		4. Verificación: Repite la prueba con un tiempo simulado de 1000 ms (1
		segundo) para verificar que el join() termina antes del timeout y el hilo no
		es interrumpido.
		*/
		int tLimite = 3000;
		TareaCostosa t1 = new TareaCostosa("T1", 5000);
		
		t1.start();
		try {
			t1.join(tLimite);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (t1.isAlive()) {
			System.out.println("Tiempo limite excedido. Cancando tarea...");
			t1.interrupt();
		}else {
			System.out.println("Tarea finalizada dentro del tiempo limite");
		}
		
	}

}
