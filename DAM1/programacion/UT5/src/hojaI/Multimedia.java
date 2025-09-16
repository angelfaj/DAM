package hojaI;

import java.util.Objects;

public class Multimedia {
	protected String titulo;
	protected String autor;
	protected Formato formato;	
	protected double duracion;
	
	public Multimedia() {}
	
	public Multimedia(String titulo, String autor, Formato formato, double duracion) {
		this.titulo = titulo;
		this.autor = autor;
		this.formato = formato;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Multimedia [titulo=" + titulo + ", autor=" + autor + ", formato=" + formato + ", duracion=" + duracion
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multimedia other = (Multimedia) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(titulo, other.titulo);
	}
	
	
	
}
