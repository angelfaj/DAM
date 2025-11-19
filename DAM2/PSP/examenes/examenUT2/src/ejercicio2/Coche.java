package ejercicio2;

public class Coche implements Runnable {
	private Parking parking;
	private String nombre;
	
	public Coche(Parking parking, String nombre) {
		this.nombre = nombre;
		this.parking = parking;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void run() {
		//Ciclo del coche
		parking.entrar(this);
		parking.aparcar(this);
		parking.salir(this);
	}

}
