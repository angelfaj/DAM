package ejerciciosRepaso;

public class Autobus extends MedioTransporte implements Transportable, Mantenible{		
	private String tipoCombustible;
	private boolean enTransito;
	private int mantenimientos;
	
	
	public Autobus(int id, int numPasajeros, double velocidadMaxima, String tipoCombustible) {
		super(id, numPasajeros, velocidadMaxima);
		this.tipoCombustible = tipoCombustible;
		enTransito = false;
		mantenimientos = 0;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	@Override
	public String toString() {
		return "Autobus " + super.toString() + ", tipoCombustible=" + tipoCombustible + ", enTransito=" + enTransito + ", mantenimientos=" + mantenimientos + "]";
	}

	@Override
	public void realizarMantenimiento() {
		mantenimientos++;
	}

	@Override
	public void iniciarViaje() {
		enTransito = true;
	}

	@Override
	public void detenerViaje() {
		enTransito = false;
	}
	
	
}
