package boletin1ej3y6runnable;

public class AtletaHilo implements Runnable{
	private String nombre;
	private final String mensajeLlegada = " llegó a la meta";
	
	public AtletaHilo(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.print((i+1) + "km ");
			try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n" + nombre + mensajeLlegada);
	}
	
}
