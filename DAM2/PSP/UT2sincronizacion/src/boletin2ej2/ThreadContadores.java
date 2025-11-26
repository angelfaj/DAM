package boletin2ej2;

public class ThreadContadores extends Thread{

	public static void main(String[] args) {
		/*Enunciado 2: “Contadores independientes”
		Supón que tienes tres cronómetros que cuentan hasta 100 por separado. Cada
		uno lo hace en su propio ritmo, pero todos están en el mismo grupo de trabajo.
		Crea un programa donde cada hilo cuente y muestre su progreso, y al final se
		indique cuántos cronómetros siguen activos.
		Objetivo oculto: Uso de bucles en hilos, agrupación con ThreadGroup, y
		activeCount() para ver cuántos hilos siguen vivos.
		*/
		
		Thread.currentThread().setName("Main");
		
		ThreadGroup grupo = new ThreadGroup("Grupo contadores");
		ThreadContadores tc = new ThreadContadores();
		
		Thread c1 = new Thread(grupo, tc, "C1");
		Thread c2 = new Thread(grupo, tc, "C2");
		Thread c3 = new Thread(grupo, tc, "C3");
		
		c1.start();
		c2.start();
		c3.start();
		
		while (c1.isAlive() || c2.isAlive() || c3.isAlive()) {
			System.out.println("Hilos activos: " + Thread.activeCount());
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Hilos activos: " + Thread.activeCount());
	}
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
