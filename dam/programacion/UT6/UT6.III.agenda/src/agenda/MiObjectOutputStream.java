package agenda;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

	public MiObjectOutputStream() throws IOException, SecurityException {
		super();
	}
	
	public MiObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	//Necesario sobreescribir este metodo para poder escribir varias veces en el mismo fichero 
	protected void writeStreamHeader() throws IOException{}

}
