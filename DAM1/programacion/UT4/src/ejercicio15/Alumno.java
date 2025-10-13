package ejercicio15;

public class Alumno {
	//Atributos
	private double vectorNotas[] = new double[4];
	private String nombre;
	//Constructores
	public Alumno() {
		
	}
	
	public Alumno(String nombre) {
		this.nombre = nombre;
	}
	
	public Alumno(String nombre, double nota []) {
		this(nombre);
		for (int i = 0; i < nota.length; i++) {
			vectorNotas[i] = nota[i];
		}
	}
	
	//Metodos
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNotas(double nota[]) {
		for (int i = 0; i < nota.length; i++) {
			vectorNotas[i] = nota[i];
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNotas() {		
		String notas = "";
		
		for(int i = 0; i < vectorNotas.length; i++) {
			notas += "Nota " + i + " :" + vectorNotas[i] + "\n";
		}
		
		return notas;
	}
	
	public double getMedia() {
		double media = 0;
		
		for(double n:vectorNotas) {
			media += n;
		}
		
		return media/vectorNotas.length;
	}
}
