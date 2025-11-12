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
			preparar();
			coordinador.esperar(numeroHilos);
			ejecutar();
			coordinador.esperar(numeroHilos);
			finalizar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void preparar() throws InterruptedException {
		System.out.println(nombre + " preparando...");
		Thread.sleep(1000);
		System.out.println(nombre + " ha terminado la fase preparar");
		coordinador.aumentarContador(numeroHilos);
	}

	public void ejecutar() throws InterruptedException {
		System.out.println(nombre + " ejecutando...");
		Thread.sleep(1000);
		System.out.println(nombre + " ha terminado la fase ejecutar");
		coordinador.aumentarContador(numeroHilos);
	}

	public void finalizar() throws InterruptedException {
		System.out.println(nombre + " finalizando...");
		Thread.sleep(1000);
		System.out.println(nombre + " ha terminado la fase finalizar");
		coordinador.aumentarContador(numeroHilos);
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
 