package boletin1;

public class Aereo extends Vehiculo{
	//Atributos
	private int numeroAsientos;
	
	//Constructores
	public Aereo(String matricula, String modelo, int numeroAsientos) {
		super(matricula, modelo);
		this.numeroAsientos = numeroAsientos;
	}

	//Metodos
	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	@Override
	public String toString() {
		return "Aereo " + super.toString() + ", numeroAsientos=" + numeroAsientos;
	}
	
	
	
}
