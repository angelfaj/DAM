package examenT5;

public class PacienteHospitalizado extends Paciente implements Atendible{
	//Atributos
	private int diasHospitalizacion;
	private double costePorDia;
	private double costeBaseTratamiento;
	private String tratamiento;		//Para que quede registrado el tratamiento pautado
	
	//Constructor
	public PacienteHospitalizado(int id, String nombre, int edad, String diagnostico, boolean ingresado, int diasHospitalizacion, double costePorDia, double costeBaseTratamiento) {
		super(id, nombre, edad, diagnostico, ingresado);
		this.costeBaseTratamiento = costeBaseTratamiento;
		this.costePorDia = costePorDia;
		this.diasHospitalizacion = diasHospitalizacion;
		this.tratamiento = "No aplica"; 	//Para mejorar la salida por pantalla
	}

	//Metodos
	public int getDiasHospitalizacion() {
		return diasHospitalizacion;
	}

	public void setDiasHospitalizacion(int diasHospitalizacion) {
		this.diasHospitalizacion = diasHospitalizacion;
	}

	public double getCostePorDia() {
		return costePorDia;
	}

	public void setCostePorDia(double costePorDia) {
		this.costePorDia = costePorDia;
	}

	public double getCosteBaseTratamiento() {
		return costeBaseTratamiento;
	}

	public void setCosteBaseTratamiento(double costeBaseTratamiento) {
		this.costeBaseTratamiento = costeBaseTratamiento;
	}

	@Override						//Aprovechamos el metodo mostrar info de la clase padre
	public String toString() {
		return "PacienteHospitalizado " + super.mostrarInfo() + ", diasHospitalizacion=" + diasHospitalizacion + ", costePorDia=" + costePorDia
				+ ", costeBaseTratamiento=" + costeBaseTratamiento + ", tratamiento=" + tratamiento + "]";
	}
	
	//Metodos heredados
	@Override
	public double calcularCosteFinal() {
		return diasHospitalizacion*costePorDia+costeBaseTratamiento;
	}

	@Override
	public void recibirTratamiento(String info) {
		tratamiento = info;
	}
	
	@Override							//Utilizamos el metodo calcularCosteFinal para generar la factura
	//Este metodo debe implementarse en la clase padre ya que no cambia para ninguno de sus hijos
	public void generarFactura() {
		System.out.println("*******FACTURA*******" + "\n" + "Coste final tratamiento: " + this.calcularCosteFinal() + "\n" + "Información del paciente: " + this);
	}
	
	
	
	
}
