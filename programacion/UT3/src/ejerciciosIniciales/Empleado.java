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
	public void getValues() {
		System.out.println("Nombre empleado: " + nombre + " edad: " + edad + " numero de empleado: " + numeroEmpleado + " salario: " + salario);
	}
	
	public void setValues(String nom, int ed, int nEm, double sal) {
		nombre = nom;
		edad = ed;
		numeroEmpleado = nEm;
		salario = sal;
	}
	
}
