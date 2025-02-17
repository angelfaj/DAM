package boletin1;

public class Perro extends Mascota{
	//Atributos
	private String raza;
	private boolean pulgas;
	
	//Constructores
	public Perro() {}
	
	public Perro(String nombre, String fechaNacimiento, int edad, Estado estado, String raza, boolean pulgas) {
		super(nombre, fechaNacimiento, edad, estado);
		this.raza = raza;
		this.pulgas = pulgas;
	}
	
	//Metodos
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public boolean isPulgas() {
		return pulgas;
	}

	public void setPulgas(boolean pulgas) {
		this.pulgas = pulgas;
	}

	@Override
	public String toString() {
		return "Perro " + super.toString() + "[raza=" + raza + ", pulgas=" + pulgas + "]";
	}
	
	@Override
	public void muestra() {
		System.out.println("Soy un perro");
		System.out.println(this);
	}
	
	@Override
	public void habla() {
		System.out.println("GUAU! GUAU!");
	}
	
}
