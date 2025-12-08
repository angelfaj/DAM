package sincronizacion;

public class HiloTicTac implements Runnable{

	private String nombre;
	private static boolean tic = false;
	private static final Object lock = new Object();
	
	public HiloTicTac(String nombre) {
		this.nombre = nombre;
	}
	
	private void fin() {
		System.out.println("Hilo interrumpido.");
	}
	
	@Override
	public  void run() {
		synchronized (lock) {
			try {
				for (int i = 0; i < 6; i++) {
					if (nombre.equalsIgnoreCase("tic")) {
						while(tic) {
							lock.wait();
						}
						tic = true;
						System.out.print(nombre + " ");
						lock.notify();
					}
					if (nombre.equalsIgnoreCase("tac")) {
						while(!tic) {
							lock.wait();
						}
						tic = false;
						System.out.println(nombre);
						lock.notify();
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				fin();
			}
		}
		
	}
	
}
