package repasoEj4;

public class Monitor {
	private boolean hiloCorriendo = false;
	
	public synchronized void correr(String nombreHilo){
		while (hiloCorriendo) {
			try {
				wait();
			}catch (InterruptedException e) {
				// TODO: handle exceptio
				e.printStackTrace();
			}
		}
		hiloCorriendo = true;
		System.out.println("Hilo " + nombreHilo + " esta CORRIENDO");
		//Simulacion de carrera
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hiloCorriendo = false;
		System.out.println("Hilo " + nombreHilo + " TERMINA de correr");
		notifyAll();
	}
}
