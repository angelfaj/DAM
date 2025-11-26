package boletin5ej2;

public class Paciente implements Runnable{
	private String nombre;
	private ConsultorioCompartido consultorio;
	
	public Paciente(String nombre, ConsultorioCompartido consultorio) {
		this.nombre = nombre;
		this.consultorio = consultorio;
	}

	@Override
	public void run() {
		consultorio.entrarConsulta(this.nombre);
	}
	
	
}
