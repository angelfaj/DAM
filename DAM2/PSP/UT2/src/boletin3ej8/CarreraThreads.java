package boletin3ej8;

public class CarreraThreads extends Thread{
	private String nombre;
	private Thread hilo;
	
	public CarreraThreads (String nombre) {
		super(nombre);
	}
	
	public Thread getHilo() {
		return hilo;
	}

	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(getName() + ": " + i);
				int aleatorio = (int) (Math.random() * (80 - 20 + 1)) + 20;
				sleep(aleatorio);
			}
			hilo.interrupt();
			System.out.println(getName() + ": He gando la carrera!");
		}catch (InterruptedException e) {
			System.out.println("Hilo " + hilo.getName() + " me ha interrumpido, dejo la carrera");
		}
	}
	
	public static void main(String[] args) {
		/*Ejercicio 8: Carrera entre hilos con interrupción controlada
		Objetivo: Combinar interrupt(), join() e isAlive() con dificultad media/alta. Uso de
		Thread.currentThread().isInterrupted() o del catch de InterruptedException.
		Sincronización de final (con join()). Interrupción entre hilos (no desde main).
		Descripción:
		Simular una “carrera” entre dos hilos:
		• Cada hilo incrementa una variable interna entre 0 y 100, pausando entre
		20–80 ms (aleatorio).
		• El primer hilo que llegue a 100 debe interrumpir al otro hilo.
		• El hilo interrumpido debe finalizar educadamente mostrando un
		mensaje: Hilo X: Me han interrumpido, dejo la carrera.
		• El ganador debe mostrar: Hilo X: ¡He ganado la carrera!
		El main debe:
		• Iniciar ambos hilos.
		• Usar join() para esperar a que ambos finalicen antes de imprimir:
		• FIN DE LA SIMULACION
		*/
		
		CarreraThreads c1 = new CarreraThreads("H1");
		CarreraThreads c2 = new CarreraThreads("H2");

		c1.setHilo(c2);
		c2.setHilo(c1);

		c1.start();
		c2.start();
		
		try {
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("FIN DE LA SIMULACION");
		
	}

}
