package ficherosBinarios;

public class Vehiculo {
	private String matricula, marca, modelo;
	private double deposito;
	private static int totalVehiculos = 0;
	
	public Vehiculo(String matricula, String marca, String modelo, double deposito) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.deposito = deposito;
		totalVehiculos++;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}

	public int getTotalVehiculos() {
		return totalVehiculos;
	}
	
	@Override
	public String toString() {
		return "V" + ": [" + matricula + "-" + marca + "-" + modelo + ", deposito="
				+ "-" + deposito
				+ "litros]";
	}
	
	
}
