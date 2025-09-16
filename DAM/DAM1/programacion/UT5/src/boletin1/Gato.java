package boletin1;

public class Gato extends Mascota{
	//Atributos
	private String color;
	private boolean peloLargo;
	
	//Constructores
	public Gato() {}
	
	public Gato(String nombre, String fechaNacimiento, int edad, Estado estado, String color, boolean peloLargo) {
		super(nombre, fechaNacimiento, edad, estado);
		this.color = color;
		this.peloLargo = peloLargo;
	}

	//Metodos
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isPeloLargo() {
		return peloLargo;
	}

	public void setPeloLargo(boolean peloLargo) {
		this.peloLargo = peloLargo;
	}
	
	@Override
	public String toString() {
		return "Gato " + super.toString() + "[color=" + color + ", peloLargo=" + peloLargo + "]";
	}

	@Override
	public void muestra() {
		System.out.println("Soy un gato");
		System.out.println(this);
	}
	
	@Override
	public void habla() {
		System.out.println("MIAU MIAU");
	}
	
}
