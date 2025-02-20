package boletin1;

public class Acuatico extends Vehiculo{
	//Atributos
	private double eslora;
	
	//Constructores
	public Acuatico(String matricula, String modelo, double eslora) {
		super(matricula, modelo);
		this.eslora = eslora;
	}

	//Metodos
	public double getEslora() {
		return eslora;
	}

	@Override
	public String toString() {
		return "Acuatico " + super.toString() + ", eslora=" + eslora;
	}
	
	
	
	
	
}
