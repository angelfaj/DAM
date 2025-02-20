package boletin1;

public class Avion extends Aereo{
	//Atributos
	private double tiempoMaximoVuelo;
	
	//Constructores
	public Avion(String matricula, String modelo, int numeroAsientos, double tiempoMaximoVuelo) {
		super(matricula, modelo, numeroAsientos);
		this.tiempoMaximoVuelo = tiempoMaximoVuelo;
	}

	//Metodos
	public double getTiempoMaximoVuelo() {
		return tiempoMaximoVuelo;
	}

	public void setTiempoMaximoVuelo(double tiempoMaximoVuelo) {
		this.tiempoMaximoVuelo = tiempoMaximoVuelo;
	}

	@Override
	public String toString() {
		return "Avion " + super.toString() + ", tiempoMaximoVuelo=" + tiempoMaximoVuelo + "]";
	}
	
	
	
}
