package boletin1;

public class Empleado extends Trabajador{
	//Atributos
	private String direccion, telefono;	
	private double salarioBrutoMensual;
	private int edad;
	
	//Constructores
	public Empleado(String nombre, String dni, double salarioBrutoMensual) {
		super(nombre, dni);
		this.salarioBrutoMensual = salarioBrutoMensual;
	}
	
	public Empleado(String nombre, String dni, double salarioBrutoMensual, int edad, String direccion, String telefono) {
		this(nombre, dni, salarioBrutoMensual);
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	//Metodos
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public double getSalarioBrutoMensual() {
		return salarioBrutoMensual;
	}

	public void setSalarioBrutoMensual(double salarioBrutoMensual) {
		this.salarioBrutoMensual = salarioBrutoMensual;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double calculaNeto() {
		double neto, brutoAnual, descuentoIRPF;
		int irpf = 0;
		
		brutoAnual = this.salarioBrutoMensual * 12;
		if (brutoAnual < 12000) {
			irpf = 20;
		}else if ((brutoAnual >= 12000 )&& (brutoAnual <= 25000)) {
			irpf = 30;
		}else if (brutoAnual > 25000) {
			irpf = 40;
		}
		descuentoIRPF = irpf * brutoAnual / 100;
		neto = this.salarioBrutoMensual - descuentoIRPF;
		return neto;
	}
	
	@Override
	public String toString() {
		return "Empleado " + super.toString() + ", salarioBrutoMensual=" + salarioBrutoMensual + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", edad=" + edad + "]";
	}
	
	
}
