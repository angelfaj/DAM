package boletin1;

public abstract class Astro {
	//Atributos
	private double radioEcuatorial;
	private double rotacionEje;
	private double masa;
	private double temperaturaMedia;
	private double gravedad;
	
	//Constructores
	public Astro() {}
	
	public Astro(Double radioEcuatorial, double rotacionEje, double masa, double temperaturaMedia, double gravedad) {
		this.radioEcuatorial = radioEcuatorial;
		this.rotacionEje = rotacionEje;
		this.masa = masa;
		this.temperaturaMedia = temperaturaMedia;
		this.gravedad = gravedad;
	}
	
	//Metodos
	public double getRadioEcuatorial() {
		return radioEcuatorial;
	}

	public void setRadioEcuatorial(double radioEcuatorial) {
		this.radioEcuatorial = radioEcuatorial;
	}

	public double getRotacionEje() {
		return rotacionEje;
	}

	public void setRotacionEje(double rotacionEje) {
		this.rotacionEje = rotacionEje;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public double getTemperaturaMedia() {
		return temperaturaMedia;
	}

	public void setTemperaturaMedia(double temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public double getGravedad() {
		return gravedad;
	}

	public void setGravedad(double gravedad) {
		this.gravedad = gravedad;
	}

	public abstract void muestra();

	@Override
	public String toString() {
		return "[radioEcuatorial=" + radioEcuatorial + ", rotacionEje=" + rotacionEje + ", masa=" + masa
				+ ", temperaturaMedia=" + temperaturaMedia + ", gravedad=" + gravedad;
	}
	
	
	
}
