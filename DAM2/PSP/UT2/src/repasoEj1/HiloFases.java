package repasoEj1;

public class HiloFases implements Runnable{
	private String nombre;
	private Coordinador coordinador;
	private static int numeroHilos;
	
	public HiloFases(String nombre, Coordinador coordinador) {
		this.nombre = nombre;
		this.coordinador = coordinador;
		numeroHilos++;
	}
	
	@Override
	public void run() {
		try {
			muestraInfo("preparar");
			coordinador.esperar(numeroHilos);
			muestraInfo("ejecutar");
			coordinador.esperar(numeroHilos);
			muestraInfo("finalizar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void muestraInfo(String fase) throws InterruptedException {
		System.out.println(nombre + " preparando...");
		Thread.sleep(1000);
		System.out.println(nombre + " ha terminado la fase " + fase);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Coordinador getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public static int getNumeroHilos() {
		return numeroHilos;
	}


}
 