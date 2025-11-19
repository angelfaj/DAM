package interrupciones;

public class ContadorActivo extends Thread {
	private boolean pararManual = false;
	
	@Override
	public void run() {
		for (int i = 1; i < 100000; i++) {
			System.out.print(i + " ");
			if (isInterrupted() || pararManual) {
				System.out.println("Hilo interrumpido, fin del programa.");
				break;
			}
		}
	}
	
	public void pararHilo() {
		pararManual = true;
	}
}
