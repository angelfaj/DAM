package hojaI;

import java.util.Date;

public class Libro extends Publicacion implements Prestable{
	private boolean prestado;
	
	public Libro(int codigo, String titulo, String f_publicacion) {
		super(codigo, titulo, f_publicacion);
		prestado = false;
	}

	public boolean isPrestado() {
		return prestado;
	}

	@Override
	public String toString() {
		return "Libro " + super.toString() + ", prestado=" + prestado + "]";
	}

	@Override
	public void prestar() {
		this.prestado = true;
	}

	@Override
	public void devolver() {
		this.prestado = false;		
	}
	
	
}
