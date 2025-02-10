package boletin3;

public class Peluquero extends Persona{
	protected double salario;
	protected int horasTrabajadas;
	
	public Peluquero(String dni) {
		super(dni);
	}
	
	public Peluquero(String nombre, String apellidos, String dni, int edad, double salario, int horasTrabajadas) {
		super(nombre, apellidos, dni, edad);
		this.salario = salario;
		this.horasTrabajadas = horasTrabajadas;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public String toString() {
		return super.toString() + "Peluquero [salario=" + salario + ", horasTrabajadas=" + horasTrabajadas + "]";
	}
	
	
	
}
