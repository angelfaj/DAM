package hojaI;

import java.util.Date;

public class Revista extends Publicacion{
	private int numero;
	
	public Revista(int codigo, String titulo, String f_publicacion, int numero) {
		super(codigo, titulo, f_publicacion);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Revista " + super.toString() + " ,numero=" + numero + "]";
	}

	
	
}
