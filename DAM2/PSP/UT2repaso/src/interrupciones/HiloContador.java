package interrupciones;

public class HiloContador implements Runnable{

	@Override
	public void run() {
		try {
			for (int i = 1;;i++) {
				System.out.print(i + " ");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Hilo interrumpido, fin de la ejecucion.");
		}
	}

}
