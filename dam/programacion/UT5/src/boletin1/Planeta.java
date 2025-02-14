package boletin1;

import java.util.ArrayList;

public class Planeta extends Astro{
	//Atributos
	private double distanciaAlSol;
	private double orbitaAlSol;
	private boolean tieneSatelites;
	private ArrayList<Satelite> satelites;
	
	public Planeta() {}
	
	public Planeta(Double radioEcuatorial, double rotacionEje, double masa, double temperaturaMedia, double gravedad, double distanciaAlSol, double orbitalAlsol, boolean tieneSatelites) {
		super(radioEcuatorial, rotacionEje, masa, temperaturaMedia, gravedad);
		this.distanciaAlSol = distanciaAlSol;
		this.orbitaAlSol = orbitalAlsol;
		this.tieneSatelites = tieneSatelites;
		if (tieneSatelites == true) {
			satelites = new ArrayList<Satelite>();
		}
	}
	
	
	@Override
	public void muestra() {
		
	}

	@Override
	public String toString() {
		return "Planeta " + super.toString() + "[distanciaAlSol=" + distanciaAlSol + ", orbitaAlSol=" + orbitaAlSol + "]";
	}
	
	
}
