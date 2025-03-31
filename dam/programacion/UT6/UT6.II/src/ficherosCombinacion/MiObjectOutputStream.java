package ficherosCombinacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream{
	protected MiObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	protected MiObjectOutputStream() throws IOException, SecurityException {
		super();
	}
	
	//Necesario sobreescribir este metodo para poder escribir varias veces en el mismo fichero 
	protected void writeStreamHeader() throws IOException{}

}
