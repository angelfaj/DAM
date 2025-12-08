package ejemplo01;

import java.util.concurrent.Semaphore;

public class IncrementadorLento extends Thread {

	private String id;
	private final ContadorCompartido cc;

	private static Semaphore semaforo = new Semaphore(1);

	public IncrementadorLento(String id, ContadorCompartido cc) {
		this.id = id;
		this.cc = cc;
	}

	@Override
	public void run() {

		try {

			semaforo.acquire();
			int valor = cc.getN();
			valor++;
			cc.setN(id, valor);
			semaforo.release();

		} catch (InterruptedException e) {
			System.err.println(id + ": " + e);
		}

	}

	
	public static void main(String[] args) {
		ContadorCompartido c= new ContadorCompartido();
		IncrementadorLento h1 = new IncrementadorLento("Hilo 1", c);
		IncrementadorLento h2 = new IncrementadorLento("Hilo 2", c);

		h1.start();
		h2.start();
		//prueba a crear un array de 10 hilos que incrementen el contador compartido y lánzalos,¿se sincronizan?
		
	}

}