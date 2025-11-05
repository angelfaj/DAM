package boletin4ej3;

public class TicTac {
	private boolean disponible = false;
	
	
	public synchronized void tic() {
		while (disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("TIC");
		disponible = true;
		notify();
	}

	public synchronized void tac() {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("TAC");
		disponible = false;
		notify();
	}
}
