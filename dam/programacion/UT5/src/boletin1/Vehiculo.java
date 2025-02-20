package boletin1;

public abstract class Vehiculo {
	//Atributos
	private String matricula;
	private String modelo;
	
	//Constructores
	public Vehiculo(String matricula, String modelo) {
		this.matricula = matricula;
		this.modelo = modelo;
	}

	//Metodos
	public String getMatricula() {
		return matricula;
	}

	public String getModelo() {
		return modelo;
	}

	@Override
	public String toString() {
		return "[matricula=" + matricula + ", modelo=" + modelo;
	}
	
	
	
	
}
