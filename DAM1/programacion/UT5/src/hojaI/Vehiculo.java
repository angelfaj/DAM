package hojaI;

public class Vehiculo {
	private double peso;
	private String matricula;
	
	public Vehiculo(String matricula, double peso) {
		this.matricula = matricula;
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [peso=" + peso + ", matricula=" + matricula + "]";
	}
	
	
}
