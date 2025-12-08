package grupos;

public class HiloSaludadores extends Thread{
	private String nombre;
	
	public HiloSaludadores(String nombre) {
		super(nombre);
	}
	
	@Override 
	public void run() {
		System.out.println("Soy "+ getName() + " y yo te saludo");
	}
}
