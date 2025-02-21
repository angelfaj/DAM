package hojaI;

public class MiTele implements Televisor{
	private int numCanales, canalActual;
	private boolean encendida;
	
	public MiTele(int numCanales, int canalActual, boolean encendida) {
		this.canalActual = canalActual;
		this.encendida = encendida;
		this.numCanales = numCanales;
	}

	public int getNumCanales() {
		return numCanales;
	}

	public void setNumCanales(int numCanales) {
		this.numCanales = numCanales;
	}

	public int getCanalActual() {
		return canalActual;
	}

	public boolean isEncendida() {
		return encendida;
	}

	public void encender() {
		this.encendida = true;
	}
	
	public void apagar() {
		this.encendida = false;
	}
	
	public void cambiarCanal(int canalActual) {
		this.canalActual = canalActual;
	}

	@Override
	public String toString() {
		return "MiTele [numCanales=" + numCanales + ", canalActual=" + canalActual + ", encendida=" + encendida + "]";
	}
	
	
	
	
}
