package hojaI;

public class Alumno2 extends Alumno implements Comparar{
	public Alumno2(String nombre, int edad) {
		super(nombre, edad);
	}

	@Override
	public boolean esMenor(Object objeto) {
		if (objeto != null) {
			if (objeto instanceof Alumno) {
				Alumno2 a = (Alumno2) objeto;
				if (this.getEdad() < a.getEdad()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean esMayor(Object objeto) {
		if (objeto != null) {
			if (objeto instanceof Alumno) {
				Alumno2 a = (Alumno2) objeto;
				if (this.getEdad() > a.getEdad()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean esIgual(Object objeto) {
		if (objeto != null) {
			if (objeto instanceof Alumno) {
				Alumno2 a = (Alumno2) objeto;
				if (this.getEdad() == a.getEdad()) {
					return true;
				}
			}
		}		return false;
	}
	
	
	
}
