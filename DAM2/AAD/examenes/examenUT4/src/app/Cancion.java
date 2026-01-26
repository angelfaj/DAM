package app;

public class Cancion {
	private String id;
	private String titulo;
	private int duracionSegundos;
	private int numeroReproducciones;
	private boolean esExplicita;
	private Artista artista; // Referencia directa al objeto

	public Cancion(String id, String titulo, int duracion, int reproducciones, boolean explicita, Artista artista) {
		this.id = id;
		this.titulo = titulo;
		this.duracionSegundos = duracion;
		this.setNumeroReproducciones(reproducciones);
		this.setEsExplicita(explicita);
		this.artista = artista;
	}

	public String getId() {
		return id;
	}

	public int getDuracionSegundos() {
		return duracionSegundos;
	}

	public Artista getArtista() {
		return artista;
	}

	public int getNumeroReproducciones() {
		return numeroReproducciones;
	}

	public void setNumeroReproducciones(int numeroReproducciones) {
		this.numeroReproducciones = numeroReproducciones;
	}

	public boolean isEsExplicita() {
		return esExplicita;
	}

	public void setEsExplicita(boolean esExplicita) {
		this.esExplicita = esExplicita;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDuracionSegundos(int duracionSegundos) {
		this.duracionSegundos = duracionSegundos;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Cancion [ID=" + id + ", Título=" + titulo + ", Duración=" + duracionSegundos + "s, Artista="
				+ artista.getNombre() + "]";
	}
}