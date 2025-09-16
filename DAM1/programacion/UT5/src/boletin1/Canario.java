package boletin1;

public class Canario extends Ave{
	//Atributos
	private String color;
	private boolean canta;
	
	//Constructores
	public Canario() {}
	
	public Canario(String nombre, String fechaNacimiento, int edad, Estado estado, boolean pico, boolean vuela, String color, boolean canta) {
		super(nombre, fechaNacimiento, edad, estado, pico, vuela);
		this.color = color;
		this.canta = canta;
	}

	//Metodos
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isCanta() {
		return canta;
	}

	public void setCanta(boolean canta) {
		this.canta = canta;
	}

	@Override
	public String toString() {
		return "Canario " + super.toString() +  "[color=" + color + ", canta=" + canta + "]";
	}
	
	@Override
	public void volar() {
		this.setVuela(true);
	}
	
	@Override
	public void muestra() {
		System.out.println("Soy un canario");
		System.out.println(this);
	}
	
	@Override 
	public void habla() {
		System.out.println("PIO PIO");
		
	}
	
	
}
