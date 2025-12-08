package repasoEj3;

public class HiloProductorConsumidor implements Runnable{
	private String tipoHilo;
	private String accion;
	private Bandeja bandeja;
	
	public HiloProductorConsumidor(String tipoHilo, Bandeja bandeja) {
		this.tipoHilo = tipoHilo;
		if (tipoHilo.equalsIgnoreCase("productor")) accion = "producir";
		if (tipoHilo.equalsIgnoreCase("consumidor")) accion = "consumir";
		this.bandeja = bandeja;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i ++) {
			System.out.println("El " + tipoHilo + " quiere " + accion.toUpperCase());
			bandeja.revisarBandeja(tipoHilo);
		}
	}

}
