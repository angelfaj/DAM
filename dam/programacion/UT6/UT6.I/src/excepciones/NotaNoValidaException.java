package excepciones;

public class NotaNoValidaException extends Exception{
	private String mensaje;
	
	public NotaNoValidaException(String mensaje) {
		this.mensaje = mensaje; 
	}
	
	@Override
	public String toString() {
		return mensaje;
	}
}
