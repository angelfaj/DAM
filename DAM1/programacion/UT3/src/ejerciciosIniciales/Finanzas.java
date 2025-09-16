package ejerciciosIniciales;

public class Finanzas {

	//Atributos
	double dolars;
	double euros;
	double valorDolarAEuro;
	
	//Constructor
	public Finanzas(double valor) {
		valorDolarAEuro = valor;
	}
	//Metodos
	public double dolarsToEuros (double dolars) {
		euros = dolars / valorDolarAEuro;
		return euros;
	}
	
	public double eurosToDolars (double euros) {
		dolars = euros * valorDolarAEuro;
		return dolars;
	}
}
