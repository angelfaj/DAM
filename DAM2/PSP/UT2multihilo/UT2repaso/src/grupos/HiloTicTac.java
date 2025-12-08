package grupos;

public class HiloTicTac extends Thread{

	@Override
	public void run() {
		try {
			while (!interrupted()) {
			System.out.println("Tic Tac");
			sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Hilos interrumpidos");
		}
		
	}

	
}
