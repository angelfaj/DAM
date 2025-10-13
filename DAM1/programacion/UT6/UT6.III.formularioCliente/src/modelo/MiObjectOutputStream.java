package modelo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream{

	protected MiObjectOutputStream() throws IOException, SecurityException {
		super();
	}

	public MiObjectOutputStream(OutputStream out) throws IOException, SecurityException {
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {}
	
}
