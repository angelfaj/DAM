package hojaI;

public class Profesor extends Empleado{
	private Departamento departamento;
	
	public Profesor() {}
	
	public Profesor(String nombre, String apellido1, String apellido2, String dni, Estado estado, int anioIncorporacion, int numeroDespacho, Departamento departamento) {
		super(nombre, apellido1, apellido2, dni, estado, anioIncorporacion, numeroDespacho);
		this.departamento = departamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Profesor " + super.toString() + " departamento=" + departamento + "]";
	}
	
	
	
}
