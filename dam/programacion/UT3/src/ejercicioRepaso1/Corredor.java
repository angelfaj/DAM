package ejercicioRepaso1;

public class Corredor {
	//Atributos
	private String nombre;
	private double velocidad;
	
	//Constructores
	public Corredor(String nombre) {
		this.nombre = nombre;
		velocidad = 10;
	}
	
	public Corredor(String nombre, double velocidad) {
		this(nombre);
		this.velocidad = velocidad;
	}
	
	//Metodos
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getVelocidad() {
		return velocidad;
	}
	
	public void mejorarVelocidad() {
		velocidad++;
	}
}
