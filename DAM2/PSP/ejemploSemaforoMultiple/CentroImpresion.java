package explicaSemaforoImpre;

import java.util.concurrent.Semaphore;

public class CentroImpresion {
	// Tenemos 2 impresoras disponibles en la empresa en total
	private Semaphore semaforo = new Semaphore(2);

	public void imprimir(String nombre) {
		try {
			System.out.println(nombre + " quiere imprimir...");
			semaforo.acquire(); // pide permiso
			System.out.println(nombre + " está imprimiendo."); //solo entra si ha conseguido el permiso, si no espera antes
			Thread.sleep(2000); // simulamos tiempo de impresión, no actualiza el número de "permisos" del
								// semáforo, sigue consumiendo su permiso el hilo que se duerme
			System.out.println(nombre + " ha terminado de imprimir.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release(); // libera la impresora con un recurso más
		}
	}
}
