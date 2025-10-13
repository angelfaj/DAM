package boletin1;

public class Loro extends Ave{
	//Atributos
	private String origen;
	private boolean habla;
	
	//Constructores
	public Loro() {}
	
	public Loro(String nombre, String fechaNacimiento, int edad, Estado estado, boolean pico, boolean vuela, String origen, boolean habla) {
		super(nombre, fechaNacimiento, edad, estado, pico, vuela);
		this.origen = origen;
		this.habla = habla;
	}
	
	//Metodos
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public boolean isHabla() {
		return habla;
	}

	public void setHabla(boolean habla) {
		this.habla = habla;
	}

	@Override
	public String toString() {
		return "Loro " + super.toString() + "[origen=" + origen + ", habla=" + habla + "]";
	}
	
	@Override
	public void volar() {
		this.setVuela(true);
	}
	
	@Override
	public void muestra() {
		System.out.println("Soy un loro");
		System.out.println(this);
	}
	
	@Override 
	public void habla() {
		System.out.println("HOLA HOLA");
		
	}
	
	
	
}
