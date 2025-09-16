package boletin1;

import java.util.ArrayList;

public class Planeta extends Astro{
	//Atributos
	private double distanciaAlSol;
	private double orbitaAlSol;
	private boolean tieneSatelites;
	private ArrayList<Satelite> satelites;
	
	//Constuctores
	public Planeta() {}
	
	public Planeta(Double radioEcuatorial, double rotacionEje, double masa, double temperaturaMedia, double gravedad, double distanciaAlSol, double orbitalAlsol, boolean tieneSatelites, double diametroMedio, double traslacion, double distanciaMediaAlCuerpo) {
		super(radioEcuatorial, rotacionEje, masa, temperaturaMedia, gravedad, diametroMedio, traslacion, distanciaMediaAlCuerpo);
		this.distanciaAlSol = distanciaAlSol;
		this.orbitaAlSol = orbitalAlsol;
		this.tieneSatelites = tieneSatelites;
		if (tieneSatelites == true) {
			satelites = new ArrayList<Satelite>();
		}
	}
	
	//Metodos
	public double getDistanciaAlSol() {
		return distanciaAlSol;
	}

	public void setDistanciaAlSol(double distanciaAlSol) {
		this.distanciaAlSol = distanciaAlSol;
	}

	public double getOrbitaAlSol() {
		return orbitaAlSol;
	}

	public void setOrbitaAlSol(double orbitaAlSol) {
		this.orbitaAlSol = orbitaAlSol;
	}

	public boolean isTieneSatelites() {
		return tieneSatelites;
	}

	public void setTieneSatelites(boolean tieneSatelites) {
		this.tieneSatelites = tieneSatelites;
	}

	public ArrayList<Satelite> getSatelites() {
		return satelites;
	}

	public void addSatelites(Satelite satelite) {
		satelites.add(satelite);
	}

	@Override
	public String toString() {
		return "Planeta " + super.toString() + "[distanciaAlSol=" + distanciaAlSol + ", orbitaAlSol=" + orbitaAlSol + "]";
	}
	
	@Override
	public void muestra() {
		
	}
	
}
