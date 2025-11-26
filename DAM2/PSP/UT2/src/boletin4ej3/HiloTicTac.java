package boletin4ej3;

public class HiloTicTac implements Runnable{
	private String nombre;
	private TicTac tt;
	
	public HiloTicTac(String nombre, TicTac tt) {
		this.nombre = nombre;
		this.tt = tt;
	}
	
	@Override
	public void run() {
		for (int i= 0; i < 6; i++) {
			if (nombre.equalsIgnoreCase("tic")) {
				tt.tic();
			}else {
				tt.tac();
			}
		}
	}
}
