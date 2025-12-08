package hilos;

public class HiloMascota extends Thread{
	private String nombre;
	private static final int DISTANCIA_CARRERA = 30;
	
	public HiloMascota(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for (int i = 0; i < DISTANCIA_CARRERA; i++) {
			System.out.println(i + "mt hilo " + nombre + " con prioridad: " + getPriority());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Llego a la meta: " + nombre);
	}
}
