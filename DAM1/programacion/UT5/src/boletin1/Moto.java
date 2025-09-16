package boletin1;

public class Moto extends Terrestre{
	private String color;
	
	public Moto(String matricula, String modelo, int numeroRuedas, String color) {
		super(matricula, modelo, numeroRuedas);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Moto " + super.toString() + ", color=" + color + "]";
	}
	
	
}
