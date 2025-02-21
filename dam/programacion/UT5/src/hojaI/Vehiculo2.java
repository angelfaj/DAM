package hojaI;

public class Vehiculo2 extends Vehiculo implements Comparar{

	public Vehiculo2(String matricula, double peso) {
		super(matricula, peso);
	}

	@Override
	public boolean esMenor(Object objeto) {
		if (objeto != null) {
			if (objeto instanceof Vehiculo) {
				Vehiculo2 v = (Vehiculo2) objeto;
				if (this.getPeso() < v.getPeso()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean esMayor(Object objeto) {
		if (objeto != null) {
			if (objeto instanceof Vehiculo) {
				Vehiculo2 v = (Vehiculo2) objeto;
				if (this.getPeso() > v.getPeso()) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean esIgual(Object objeto) {
		if (objeto != null) {
			if (objeto instanceof Vehiculo) {
				Vehiculo2 v = (Vehiculo2) objeto;
				if (this.getPeso() == v.getPeso()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
