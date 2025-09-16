package boletin1;

public class Consultor extends Trabajador{
	//Atributos
	private int horas;
	private double tarifa;
	
	//Constuctores
	public Consultor(String nombre, String dni) {
		super(nombre, dni);
	}
	
	public Consultor(String nombre, String dni, int horas, double tarifa) {
		this(nombre, dni);
		this.horas = horas;
		this.tarifa = tarifa;		
	}

	//Metodos
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	
}
