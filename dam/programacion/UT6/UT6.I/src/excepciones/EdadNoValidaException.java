package excepciones;

public class EdadNoValidaException extends Exception{
	private String mensaje;
	
	public EdadNoValidaException(String mensaje) {		
		this.mensaje = mensaje;
	}
	
	public EdadNoValidaException() {		
		super("constructor padre");
	}
	
	@Override
	public String toString() {
		return mensaje;
	}
}
