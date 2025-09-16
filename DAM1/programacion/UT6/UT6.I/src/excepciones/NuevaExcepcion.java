package excepciones;

public class NuevaExcepcion extends Exception{
	private String cadena;
	
	public NuevaExcepcion(String cadena) {
		this.cadena = cadena;
	}

	@Override
	public String toString() {
		return "NuevaExcepcion [cadena=" + cadena + "]";
	}
	
	
}
