package ejemploHerencia;

public class Empleado extends Persona{
	long sueldo;
	
	public Empleado() {}	//Llama al constructor por defecto de persona

	public Empleado(String nombre, int edad, long sueldo) {
		super(nombre, edad);
		this.sueldo = sueldo;
	}

	public long getSueldo() {
		return sueldo;
	}

	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return super.toString() + "sueldo=" + sueldo + "]";
	}



}
