package hilos;

public class HiloEmpleado extends Thread {
	private String nombre;
	private String dia;
	private double horaLlegada;
	private static final double INICIO_JORNADA = 8;

	public HiloEmpleado(String nombre, String dia, double horaLlegada) {
		this.nombre = nombre;
		this.dia = dia;
		this.horaLlegada = horaLlegada;
	}
	
	@Override
	public void run() {
		String llegada;
		if (horaLlegada > INICIO_JORNADA) {
			llegada = "tarde";
		}else {
			llegada = "temprano";
		}
		
		System.out.println(nombre + " llego " + llegada + " el dia " + dia);
	}
}
