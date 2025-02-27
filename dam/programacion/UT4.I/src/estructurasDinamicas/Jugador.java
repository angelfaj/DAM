package estructurasDinamicas;

import java.util.HashSet;

public class Jugador {
	//Atributos
	private String nombre;
	
	
	//constructores
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	//Metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static String showList(HashSet<Jugador> h) {
		String lista = "[";
		for (Jugador j:h) {
			lista += " : " + j.getNombre(); 
		}
		lista += " : ]";
		return lista;
	}
}
