package ejerciciosRepaso;

public abstract class MedioTransporte {
	private int id, numPasajeros;
	private double velocidadMaxima;
	
	public MedioTransporte(int id, int numPasajeros, double velocidadMaxima) {
		this.numPasajeros = numPasajeros;
		this.id = id;
		this.velocidadMaxima = velocidadMaxima;
	}

	public int getId() {
		return id;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", numPasajeros=" + numPasajeros + ", velocidadMaxima=" + velocidadMaxima;
	}
	
	
	
}
