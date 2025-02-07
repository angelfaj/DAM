package ejemploHerencia;

public class Directivo extends Empleado{
	
	int categoria;
	
	public Directivo() {}
	
	public Directivo(String nombre, int edad, long sueldo, int categoria) {
		super(nombre, edad, sueldo);
		this.categoria = categoria;
	}
	
	public int getCategoria() {
		return this.categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return super.toString() + "categoria=" + categoria + "]";
	}

	
}
