package excepciones;

public class NombreGatoException extends Exception{
	private String mensaje;
	
	public NombreGatoException(String m) {
		this.mensaje = m;
	}
	
	@Override
	public String toString() {
		return mensaje;
	}
}
