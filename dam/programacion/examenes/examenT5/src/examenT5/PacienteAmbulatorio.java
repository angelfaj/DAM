package examenT5;

public class PacienteAmbulatorio extends Paciente{
	//Atributos
	private int numeroConsultas;

	//Constructor
	public PacienteAmbulatorio(int id, String nombre, int edad, String diagnostico, boolean ingresado, int numeroConsultas) {
		super(id, nombre, edad, diagnostico, ingresado);
		this.numeroConsultas = numeroConsultas;
	}

	//Metodos
	public int getNumeroConsultas() {
		return numeroConsultas;
	}

	public void setNumeroConsultas(int numeroConsultas) {
		this.numeroConsultas = numeroConsultas;
	}

	@Override						//Aprovechamos el metodo mostrar info de la clase padre
	public String toString() {				
		return "PacienteAmbulatorio " + super.mostrarInfo() + ", numeroConsultas=" + numeroConsultas + "]";
	}

	//Metodos heredados
	@Override
	public double calcularCosteFinal() {
		return numeroConsultas*100;
	}


	@Override					//Utilizamos el metodo calcularCosteFinal para generar la factura
	public void generarFactura() {
		System.out.println("*******FACTURA*******" + "\n" + "Coste final tratamiento: " + this.calcularCosteFinal() + "\n" + "Información del paciente: " + this);
	}
	
	
	
	
	
}
