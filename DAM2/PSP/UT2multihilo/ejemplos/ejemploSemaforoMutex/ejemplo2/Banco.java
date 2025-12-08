package ejemplo2;

import java.io.FileNotFoundException;
import java.util.concurrent.Semaphore;

public class Banco extends Thread {

	int transaccion;
	Cuenta c = new Cuenta();
	String tipo;
	static Semaphore available = new Semaphore(1);

	public Banco(String nombre, int transaccion, Cuenta c, String tipo) {
		super(nombre);
		this.transaccion = transaccion;
		this.c = c;
		this.tipo = tipo;
	}

	// se sobreescribe el metodo run, que es el que correra al momento de iniciar
	// los hilos con start
	@Override
	public void run() {
		try {
			// el hilo adquiere permiso para entrar a la seccion critica
			available.acquire();
			if (this.tipo.equals("ingreso")) {
				System.out.println("El hilo " + getName() + " solicita ingresar");
				c.ingreso(transaccion);
				System.out.println("Tras el ingreso de " + transaccion + " hay en la cuenta " + Cuenta.cuenta);
			} else {
				System.out.println("El hilo " + getName() + " solicita retirar");
				c.retirada(transaccion);
				System.out.println("Tras la retirada de " + transaccion + " hay en la cuenta " + Cuenta.cuenta);
			}

			// el hilo libera el permiso
			available.release();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Cuenta cuenta = new Cuenta();
		Banco a = new Banco("Hilo1", 50, cuenta, "ingreso");
		Banco b = new Banco("Hilo2", 10, cuenta, "retirada");
		// se crean los hilos asociados a cada instancia de la clase
		a.start();
		b.start();
		// join de los hilos con el hilo principal de ejecucion
		a.join();
		b.join();
		System.out.println("Total en cuenta:" + Cuenta.cuenta);

	}

}
