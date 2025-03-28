package ficherosObject;

import java.io.Serializable;

public class Alumno extends Persona{
	private Fecha f_nacimiento;
	
	public Alumno(String dni, String nombre, int edad, Fecha f_nacimiento) {
		super(dni, nombre, edad);
		this.f_nacimiento = f_nacimiento; 
	}
	
	public Alumno(String dni, String nombre, int edad) {
		super(dni, nombre, edad);
	}

	public Fecha getF_nacimiento() {
		return f_nacimiento;
	}

	public void setF_nacimiento(Fecha f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}

	@Override
	public String toString() {
		return "Alumno " + super.toString() + ", f_nacimiento=" + f_nacimiento + "]";
	}
	
	
	
	
}
