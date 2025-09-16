package hojaI;

public class Disco extends Multimedia{
	protected Genero genero;
	
	public Disco(String titulo, String autor, Formato formato, double duracion, Genero genero) {
		super(titulo, autor, formato, duracion);
		this.genero = genero;
	}

	
	
	public Genero getGenero() {
		return genero;
	}



	public void setGenero(Genero genero) {
		this.genero = genero;
	}



	@Override
	public String toString() {
		return super.toString() + "Disco [genero=" + genero + "]";
	}
	
	
}
