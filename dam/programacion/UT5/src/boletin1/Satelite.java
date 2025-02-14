package boletin1;

public class Satelite extends Astro{
	//Atributos
	private double distanciaAlPlaneta;
	private double orbitaPlanetaria;
	private String planetaPertenece;
	
	//COnstructores
	public Satelite() {}
	
	public Satelite(Double radioEcuatorial, double rotacionEje, double masa, double temperaturaMedia, double gravedad, double distanciaAlPlaneta, double OrbitaPlanetaria, String planetaPertenece) {
		super(radioEcuatorial, rotacionEje, masa, temperaturaMedia, gravedad);
		this.distanciaAlPlaneta = distanciaAlPlaneta;
		this.orbitaPlanetaria = orbitaPlanetaria;
		this.planetaPertenece = planetaPertenece;
	}

	//Metodos
	public double getDistanciaAlPlaneta() {
		return distanciaAlPlaneta;
	}

	public void setDistanciaAlPlaneta(double distanciaAlPlaneta) {
		this.distanciaAlPlaneta = distanciaAlPlaneta;
	}

	public double getOrbitaPlanetaria() {
		return orbitaPlanetaria;
	}

	public void setOrbitaPlanetaria(double orbitaPlanetaria) {
		this.orbitaPlanetaria = orbitaPlanetaria;
	}

	public String getPlanetaPertenece() {
		return planetaPertenece;
	}

	public void setPlanetaPertenece(String planetaPertenece) {
		this.planetaPertenece = planetaPertenece;
	}
	
	@Override
	public void muestra() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Satelite" + super.toString() + "[distanciaAlPlaneta=" + distanciaAlPlaneta + ", orbitaPlanetaria=" + orbitaPlanetaria
				+ ", planetaPertenece=" + planetaPertenece + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
