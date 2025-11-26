package repasoEj3;

public class Bandeja {
	private boolean hayMensaje = false;
	
	public synchronized void revisarBandeja(String tipoHilo) {
		if (tipoHilo.equalsIgnoreCase("productor")) {
			while (hayMensaje) {
				try {
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Hilo " + tipoHilo + " ha PRODUCIDO");
			hayMensaje = true;
			notify();
		}else if (tipoHilo.equalsIgnoreCase("consumidor")) {
			while (!hayMensaje) {
				try {
					wait();
				}catch (InterruptedException e) {
					// TODO: handle exceptio
					e.printStackTrace();
				}
			}
			System.out.println("Hilo " + tipoHilo + " ha CONSUMIDO");
			hayMensaje = false;
			notify();
		}
	}
}
