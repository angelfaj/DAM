package ejerciciosIniciales;

public class Empleado {
	
	//Atributos
	public static String nombre;
	public static int edad, numeroEmpleado;
	public static double salario;
	
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
	public String getValues() {
		String values = "Nombre empleado: " + nombre + " edad: " + edad + " numero de empleado: " + numeroEmpleado + " salario: " + salario; 
		return values;
	}
	
	public void setValues(String nom, int ed, int nEm, double sal) {
		nombre = nom;
		edad = ed;
		numeroEmpleado = nEm;
		salario = sal;
	}
	
	public void plusSalario(double plus) {
		if (edad >= 40) {
			salario += plus;
		}
	}
	
	public void plusSalario(double plus, int retencion) {
		if (edad >= 40) {
			salario += plus - (plus * retencion / 100);
		}
	}
	
}
