package app;

public class Artista {
	private String id;
	private String nombre;
	private String generoMusical;
	private int oyentesMensuales;

	public Artista(String id, String nombre, String generoMusical, int oyentesMensuales) {
		this.id = id;
		this.nombre = nombre;
		this.generoMusical = generoMusical;
		this.oyentesMensuales = oyentesMensuales;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public int getOyentesMensuales() {
		return oyentesMensuales;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public void setOyentesMensuales(int oyentesMensuales) {
		this.oyentesMensuales = oyentesMensuales;
	}

	@Override
	public String toString() {
		return "Artista [ID=" + id + ", Nombre=" + nombre + ", Género=" + generoMusical + "]";
	}
}