package boletin1;

public class Helicoptero extends Aereo{
	//Atributos
	private int numeroHelices;
	
	//Constructores
	public Helicoptero(String matricula, String modelo, int numeroAsientos, int numeroHelices) {
		super(matricula, modelo, numeroAsientos);
		this.numeroHelices = numeroHelices;
	}

	//Metodos
	public int getNumeroHelices() {
		return numeroHelices;
	}

	public void setNumeroHelices(int numeroHelices) {
		this.numeroHelices = numeroHelices;
	}

	@Override
	public String toString() {
		return "Helicoptero " + super.toString() + ", numeroHelices=" + numeroHelices + "]";
	}
	
	
	
	
	
}
