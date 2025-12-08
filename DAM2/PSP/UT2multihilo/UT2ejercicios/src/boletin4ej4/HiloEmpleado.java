package boletin4ej4;

public class HiloEmpleado implements Runnable {
	private String nombre;
	private String tipoEmpleado; //Entrante o saliente
	private EntrandoSaliendo es;
	
	public HiloEmpleado(String nombre, String tipoEmpleado, EntrandoSaliendo es) {
		this.nombre = nombre;
		this.tipoEmpleado = tipoEmpleado;
		this.es = es;
	}

	@Override
	public void run() {
		if (tipoEmpleado.equalsIgnoreCase("entrante")) {
			es.entrar(nombre);
		}else if (tipoEmpleado.equalsIgnoreCase("saliente")) {
			es.salir(nombre);
		}
	}
	
	
	
}
