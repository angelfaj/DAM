package ejerciciosInicialesv2;

public class Vehiculo {
	//Atributos
	private int numeroRuedas;
	private double velocidadMax, peso;
	
	//Constructores
	public Vehiculo(int ruedas, double velocidad, double peso) {
		numeroRuedas = ruedas;
		velocidadMax = velocidad;
		this.peso = peso;
	}

	//Metodos
	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	public void setNumeroRuedas(int numeroRuedas) {
		
		this.numeroRuedas = numeroRuedas;
	}

	public double getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(double velocidadMax) {
		this.velocidadMax = velocidadMax;
	}
	
	public double getpeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public boolean esIgual(Vehiculo v) {
		boolean esIgual = false;
		if ((this.getNumeroRuedas() == v.getNumeroRuedas()) & (this.getVelocidadMax() == v.getVelocidadMax()) & (this.getpeso() == v.getpeso())) {
			esIgual =true;
		}
		return esIgual;
	}
	
	public void copia(Vehiculo v) {
		this.numeroRuedas = v.getNumeroRuedas();
		this.velocidadMax = v.getVelocidadMax();
		this.peso = v.getpeso();
	}
}
