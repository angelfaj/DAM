package estructurasDinamicas;

import java.util.HashSet;

public class Jugadores {
	//Atributos
	private HashSet<Jugador> plantilla;
	
	//Constructores
	public Jugadores() {
		plantilla = new HashSet<Jugador>();
	}
	
	//Metodos
	public void addJugador(Jugador j) {
		plantilla.add(j);
	}
	
	public HashSet<Jugador> getPlantilla() {
		return plantilla;
	}
	
	public String showPlantilla() {
		String lista = "[ ";
		for (Jugador j : plantilla) {
			lista += j.getNombre() + ":";
		}
		lista += " ]";
		return lista;
	}
	
	public boolean searchJugador(String nombre) {
		for (Jugador j: plantilla) {
			if (j.getNombre().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean jugadorExist(Jugador j) {
		if (plantilla.contains(j)) {
			return true;
		} else return false;
	}
	
	
}
