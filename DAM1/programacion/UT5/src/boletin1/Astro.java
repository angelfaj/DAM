package boletin1;

public abstract class Astro {
	//Atributos
	private double radioEcuatorial;
	private double rotacionEje;
	private double masa;
	private double temperaturaMedia;
	private double gravedad;
	private double diametroMedio, traslacion, distanciaMediaAlCuerpo;
	
	//Constructores
	public Astro() {}
	
	public Astro(Double radioEcuatorial, double rotacionEje, double masa, double temperaturaMedia, double gravedad, double diametroMedio, double traslacion, double distanciaMediaAlCuerpo) {
		this.radioEcuatorial = radioEcuatorial;
		this.rotacionEje = rotacionEje;
		this.masa = masa;
		this.temperaturaMedia = temperaturaMedia;
		this.gravedad = gravedad;
		this.diametroMedio = diametroMedio;
		this.traslacion = traslacion;
		this.distanciaMediaAlCuerpo = distanciaMediaAlCuerpo;
	}
	
	public double getDiametroMedio() {
		return diametroMedio;
	}

	public void setDiametroMedio(double diametroMedio) {
		this.diametroMedio = diametroMedio;
	}

	public double getTraslacion() {
		return traslacion;
	}

	public void setTraslacion(double traslacion) {
		this.traslacion = traslacion;
	}

	public double getDistanciaMediaAlCuerpo() {
		return distanciaMediaAlCuerpo;
	}

	public void setDistanciaMediaAlCuerpo(double distanciaMediaAlCuerpo) {
		this.distanciaMediaAlCuerpo = distanciaMediaAlCuerpo;
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
