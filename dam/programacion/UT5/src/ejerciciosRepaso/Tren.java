package ejerciciosRepaso;

public class Tren extends MedioTransporte implements Transportable, Mantenible{
	private int numeroVagones;
	private boolean enTransito;
	private int mantenimientos;
	

	public Tren(int id, int numPasajeros, double velocidadMaxima, int numeroVagones) {
		super(id, numPasajeros, velocidadMaxima);
		this.numeroVagones = numeroVagones;
		enTransito = false;
		mantenimientos = 0;
	}

	public int getNumeroVagones() {
		return numeroVagones;
	}

	public void setNumeroVagones(int numeroVagones) {
		this.numeroVagones = numeroVagones;
	}

	@Override
	public String toString() {
		return "Tren " + super.toString() + ", numeroVagones=" + numeroVagones + ", enTransito=" + enTransito + ", mantenimientos=" + mantenimientos + "]";
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
