package examenT5;

public abstract class Paciente implements Facturable{		//Implementamos en la clase padre la interfaz para que todas sus hijas deban implementarlo y sobreescribirlo 
	//Atributos
	private int id;
	private String nombre;
	private int edad;
	private String diagnostico;
	private boolean ingresado;

	//Constructores
	public Paciente(int id, String nombre, int edad, String diagnostico, boolean ingresado) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.diagnostico = diagnostico;
		this.ingresado = ingresado;
	}

	//Metodos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public boolean isIngresado() {
		return ingresado;
	}

	public void setIngresado(boolean ingresado) {
		this.ingresado = ingresado;
	}
	
	//Metodos comunes
	public void ingresar() {
		this.ingresado = true;
	}

	public void darAlta() {
		this.ingresado = false;
	}

	public String mostrarInfo() {
		return "[id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", diagnostico=" + diagnostico
				+ ", ingresado=" + ingresado;
	}
	
	//Metodos a sobreescribir por las clases hijas
	public abstract double calcularCosteFinal();
	
	
	
	
}
