package hojaI;

public class Personal extends Empleado{
	private Seccion seccion;
	
	public Personal() {}
	
	public Personal(String nombre, String apellido1, String apellido2, String dni, Estado estado, int anioIncorporacion, int numeroDespacho, Seccion seccion) {
		super(nombre, apellido1, apellido2, dni, estado, anioIncorporacion, numeroDespacho);
		this.seccion = seccion;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	@Override
	public String toString() {
		return "Personal " + super.toString() + " seccion=" + seccion + "]";
	}
	
	
	
	
}
