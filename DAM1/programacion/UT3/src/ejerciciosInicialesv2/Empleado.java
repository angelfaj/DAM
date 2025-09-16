package ejerciciosInicialesv2;

public class Empleado {
	//Atributos
	private String nombre, telefono;
	private static int numEmpleados;
	
	//Constructores
	public Empleado(String nom, String tel) {
		nombre = nom;
		telefono = tel;
		numEmpleados++;
	}
	//Constructor copia
	public Empleado(Empleado e) {
		nombre = e.getNombre();
		telefono = e.getTelefono();
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public void setTelefono(String tel) {
		telefono = tel;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public static int getNumEmpleados() {
		return numEmpleados;
	}
	
	public static boolean equals(Empleado emp1, Empleado emp2) {
		boolean iguales = false;
		if (emp1.equals(emp2)) {			//(emp1.getNombre().equals(emp2.getNombre())) && (emp1.getTelefono().equals(emp2.getTelefono()))
			iguales = true;
		}
		return iguales;
	}
	
}
