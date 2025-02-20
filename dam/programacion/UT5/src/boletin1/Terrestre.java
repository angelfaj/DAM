package boletin1;

public class Terrestre extends Vehiculo{
	//Atributos
	private int numeroRuedas;
	
	//Constructores
	public Terrestre(String matricula, String modelo, int numeroRuedas) {
		super(matricula, modelo);
		this.numeroRuedas = numeroRuedas;				
	}

	//Metodos
	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	@Override
	public String toString() {
		return "Vehiculo terrestre " + super.toString() + ", numeroRuedas=" + numeroRuedas;
	}
	
	
	
}
