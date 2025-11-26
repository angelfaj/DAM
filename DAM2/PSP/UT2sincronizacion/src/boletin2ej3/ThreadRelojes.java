package boletin2ej3;

public class ThreadRelojes extends Thread{

	public static void main(String[] args) {
		/*Enunciado 3: “Apagar todos los relojes”
		Tienes varios relojes que hacen “tic tac” cada segundo. Después de un rato,
		decides apagar todos a la vez. Crea un programa donde cada reloj sea un hilo
		que imprime “tic tac” cada segundo, y luego interrumpe todos los relojes juntos
		usando el grupo.
		Objetivo oculto: Uso de sleep(), interrupt(), y control grupal con ThreadGroup.
		*/
		
		Thread.currentThread().setName("Main");
		ThreadRelojes tr = new ThreadRelojes();
		ThreadGroup grupo = new ThreadGroup("Grupo relojes");
		
		Thread r1 = new Thread(grupo, tr, "R1");
		Thread r2 = new Thread(grupo, tr, "R2");
		Thread r3 = new Thread(grupo, tr, "R3");

		r1.start();
		r2.start();
		r3.start();
		
		System.out.println("Hilos activos: " + Thread.activeCount());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Interrumpimos hilos...");
		grupo.interrupt();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hilos activos: " + Thread.activeCount());
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getName() + ": tic tac");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + ": terminado.");
	}
}
