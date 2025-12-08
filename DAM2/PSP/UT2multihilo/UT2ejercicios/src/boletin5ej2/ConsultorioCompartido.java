package boletin5ej2;

import java.util.concurrent.Semaphore;

public class ConsultorioCompartido {
	private static final Semaphore semaforo = new Semaphore(5);
	
	public void entrarConsulta(String nombre) {
		System.out.println("Paciende " + nombre + " ESPERANDO");
		try {
			semaforo.acquire();
			System.out.println("Paciende " + nombre + " EN CONSULTA");
			System.out.println("Paciende " + nombre + " SALIENDO");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}

}
