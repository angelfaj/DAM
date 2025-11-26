package repasoEj4;

public class HiloCorredor extends Thread{

	private String nombre;
	private Monitor monitor;
	
	public HiloCorredor(String nombre, Monitor monitor) {
		this.monitor = monitor;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		System.out.println("Hilo " + nombre + " esta PREPARADO para correr");
		monitor.correr(nombre);
	}
	
}
