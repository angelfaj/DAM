package boletin1;

public class Coche extends Terrestre{
	private boolean aireAcondicionado;
	
	public Coche(String matricula, String modelo, int numeroRuedas, boolean aireAcondicionado) {
		super(matricula, modelo, numeroRuedas);
		this.aireAcondicionado = aireAcondicionado;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	@Override
	public String toString() {
		return "Coche " + super.toString() + ", aireAcondicionado=" + aireAcondicionado + "]";
	}
	
	
}
