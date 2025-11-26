package boletin4ej4;

public class EntrandoSaliendo {
	private boolean entrando = false;
//	private boolean saliendo = false;
	private static Integer numSaliendo = 0; //jugar con la cantidad y restar de nuevo hasta llegar ac ero para saber que han terminado de salir
	
	public synchronized void entrar(String nombre) {
		while (entrando) {
			try {
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		saliendo = false;
		entrando = true;
		System.out.println("Hilo " + nombre + " ENTRANDO" + "\n¿Hay alguien entrando?: " + entrando + " numero saliendo: " + numSaliendo);
		notifyAll();
	}

	public synchronized void salir(String nombre) {
		while (entrando) {
			try {
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		numSaliendo++;
//		saliendo = true;
		entrando = false;
		System.out.println("Hilo " + nombre + " SALIENDO" + "\n¿Hay alguien entrando?: " + entrando + " numero saliendo: " + numSaliendo);
		notifyAll();
	}
}
