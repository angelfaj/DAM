package boletinRepaso;

import java.util.ArrayList;

public class Presencial extends Curso{
	private String ubicacionAula;
	private ArrayList<Estudiante> listaInscritos;
	
	public Presencial(int id, String nombre, String clasificacion, String profesor, int horas, int precio, String ubicacionAula) {
		super(id, nombre, clasificacion, profesor, horas, precio);
		this.ubicacionAula = ubicacionAula;
		listaInscritos = new ArrayList<Estudiante>(); 
	}


	public String getUbicacionAula() {
		return ubicacionAula;
	}

	public void setUbicacionAula(String ubicacionAula) {
		this.ubicacionAula = ubicacionAula;
	}
	
	@Override
	public String toString() {
		return "Curso presencial " + super.toString() + ", ubicacionAula=" + ubicacionAula + "]";
	}


	@Override
	public void inscribir(Estudiante e) {
		if (listaInscritos.contains(e)) {
			System.out.println("El estudiante a esta inscrito");
		} else {
			listaInscritos.add(e);
		}
	}

	@Override
	public void getCertificado() {
		System.out.println("******************ESTE ES TU CERTIFICADO******************");
	}
	
	
}
