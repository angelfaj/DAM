package ejerciciosIniciales;

public class Numero {
	
	//Atributos
	int numero;
	
	//Constructores
	public Numero() {
		
	}
	
	public Numero(int num) {
		numero = num;
	}
	
	//Metodos
	public void añade(int sum) {
		numero += sum;
	}
	
	public void resta(int rest) {
		numero -= rest;
	}
	
	public double getValor() {
		return numero;
	}
	
	public double getDoble() {
		return numero * 2;
	}
	
	public double getTriple() {
		return numero * 3;
	}
		
	public double setNumero(int num) {
		numero = num;
		return numero;
	}
}
