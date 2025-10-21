package boletin1ej3;

public class HiloAtleta extends Thread{
	private String nombreAtleta;
	private static final int DISTANCIA = 30;
	
	public HiloAtleta(String nombreAtleta) {
		this.nombreAtleta = nombreAtleta;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= DISTANCIA; i++) {
			System.out.print(i + "km ");
			try {
				HiloAtleta.sleep(3500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("\n" + nombreAtleta + " llegço a la meta.");
	}
	
}
