package hojaI;

public class Estudiante extends Persona{
	private String curso;
	
	public Estudiante() {}
	
	public Estudiante(String nombre, String apellido1, String apellido2, String dni, Estado estado, String curso) {
		super(nombre, apellido1, apellido2, dni, estado);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Estudiante " + super.toString() + " curso=" + curso + "]";
	}
	
	
	
	
}
