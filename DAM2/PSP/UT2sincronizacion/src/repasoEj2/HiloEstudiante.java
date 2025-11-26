package repasoEj2;

public class HiloEstudiante implements Runnable{
	private String nombre;
	private MonitorEstudiante moni;
	private int turno;
	
	public HiloEstudiante(String nombre, MonitorEstudiante moni) {
		this.nombre = nombre;
		this.moni = moni;
		if (nombre.equalsIgnoreCase("A")) turno = 1;
		if (nombre.equalsIgnoreCase("B")) turno = 2;
		if (nombre.equalsIgnoreCase("C")) turno = 3;
	}
	
	@Override
	public void run() {
		System.out.println("Hilo " + nombre + " PIDE turno");
		moni.darTurno(nombre, turno);
	}

}
