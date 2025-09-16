package hojaI;

public class Empleado extends Persona{
	private int anioIncorporacion;
	private int numeroDespacho;
	
	public Empleado() {}
	
	public Empleado(String nombre, String apellido1, String apellido2, String dni, Estado estado, int anioIncorporacion, int numeroDespacho) {
		super(nombre, apellido1, apellido2, dni, estado);
		this.anioIncorporacion = anioIncorporacion;
		this.numeroDespacho = numeroDespacho;
	}


	public int getNumeroDespacho() {
		return numeroDespacho;
	}


	public void setNumeroDespacho(int numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}


	@Override
	public String toString() {
		return super.toString() + " anioIncorporacion=" + anioIncorporacion + ", numeroDespacho=" + numeroDespacho;
	}
	
	
	
	
	
	
}
