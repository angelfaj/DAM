package ejerciciosIniciales;

public class Empleado {
	
	//Atributos
	public String nombre;
	public int edad, numeroEmpleado;
	public double salario;
	
	//Constructores
	public Empleado(String nom, int ed, int nEm, double sal) {
		nombre = nom;
		edad = ed;
		numeroEmpleado = nEm;
		salario = sal;
	}
	
	public Empleado() {
		
	}
	
	//Metodos
	public String getAllValues() {
		String values = "Nombre empleado: " + nombre + " edad: " + edad + " numero de empleado: " + numeroEmpleado + " salario: " + salario; 
		return values;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public int getNumEmp() {
		return numeroEmpleado;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setAllValues(String nom, int ed, int nEm, double sal) {
		nombre = nom;
		edad = ed;
		numeroEmpleado = nEm;
		salario = sal;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public void setEdad(int ed) {
		edad = ed;
	}
	
	public void setNombre(int nEm) {
		numeroEmpleado = nEm;
	}
	
	public void setSalario(double sal) {
		salario = sal;
	}
	
	
	//Los boolean nos aseguran que las operaciones se realizan corectamente.
	public boolean plusSalario(double plus) {
		boolean centinela = false;
		if (edad >= 40) {
			salario += plus;
			centinela = true;
		}
		return centinela;
	}
	
	public boolean plusSalario(double plus, int retencion) {
		boolean centinela = false;
		if (edad >= 40) {
			salario += plus - (plus * retencion / 100);
			centinela = true;
		}
		return centinela;
	}
	
}
