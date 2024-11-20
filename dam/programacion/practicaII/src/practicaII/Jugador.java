package practicaII;

public class Jugador {
	//Atributos
	private String nombre;
	private int puntuacion;
	
	//Constructores
	public Jugador(String nombre) {						//Constructor para crear un jugador solo con nombre
		this.nombre = nombre;
	}
	
	public Jugador(String nombre, int puntuacion) {		//Constructor para crear un jugador con nombre y puntuacion
		this(nombre);
		this.puntuacion = puntuacion;
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public void incrementarPuntuacion()  {
		puntuacion++;
	}
	
}
