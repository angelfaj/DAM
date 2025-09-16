package boletin1;

public abstract class Ave extends Mascota{
	//Atributos
	private boolean pico, vuela;
	
	public Ave() {};
	
	public Ave(String nombre, String fechaNacimiento, int edad, Estado estado, boolean pico, boolean vuela) {
		super(nombre, fechaNacimiento, edad, estado);
		this.pico = pico;
		this.vuela = vuela;
	}

	public boolean isPico() {
		return pico;
	}

	public void setPico(boolean pico) {
		this.pico = pico;
	}

	public boolean isVuela() {
		return vuela;
	}

	public void setVuela(boolean vuela) {
		this.vuela = vuela;
	}
	
	
	
	@Override
	public String toString() {
		return "Ave " + super.toString() + "[pico=" + pico + ", vuela=" + vuela;
	}

	public abstract void volar();
	
	
	
	
}
