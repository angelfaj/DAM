package hojaI;

import java.util.Date;

public abstract class Publicacion {
	private int codigo;
	private String titulo;
	private String f_publicacion; //año/mes/dia 
	
	public Publicacion(int codigo, String titulo, String f_publicacion) {
		this.codigo = codigo;
		this.f_publicacion = f_publicacion;
		this.titulo = titulo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getF_publicacion() {
		return f_publicacion;
	}

	@Override
	public String toString() {
		return "[codigo=" + codigo + ", titulo=" + titulo + ", f_publicacion=" + f_publicacion;
	}
	
	
}
