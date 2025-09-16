package practicaII;
import java.lang.Math;

public class Partido {
	//Atributos
	private Jugador j1, j2;							//j1 y j2 apuntaran a los valores de los jugadores que le pasemos al constructor
	private int p1, p2;								//p1 y p2 guardaran la puntuacion aleatoria generada durante el partido
	
	//Constructores
	public Partido(Jugador j1, Jugador j2 ) {		//Aprovechamos para crear referencias a los valores de cada jugador asi más abajo podremos acceder  sus valores
		this.j1 = j1;
		this.j2 = j2;
	}
	
	//Metodos
	public String mostrarInformacionJugadores() {		//Mostramos información de cada jugador
		return "Jugador 1: " + j1.getNombre() + " - Ranking " + j1.getPuntuacion() + "\n" + "Jugador 2: " + j2.getNombre() + " - Ranking " + j2.getPuntuacion();
	}
	
	private String determinarGanador() {						//Devuelve el string ganador para utilizarlo en el metodo jugar e imprimirlo posteriormente
		String ganador = "";
		do {													//Este bucle se repetirá en caso de que las puntuaciones sean iguales
			p1 = (int)(Math.random()*10) * j1.getPuntuacion();
			p2 = (int)(Math.random()*10) * j2.getPuntuacion();
		} while (p1 == p2);
		
		if (p1 > p2) {											//Mediante este condicional guardamos el nombre del ganador
			ganador = "El ganador es: "+ j1.getNombre();
		} else {
			ganador = "El ganador es: "+ j2.getNombre();
		}
		return ganador;
	}
	
	public String jugar() {
		String ganador = determinarGanador();		//Guardamos el ganador en una variable
		
		if( p1 > p2 ) {						//Sumamos 1 al ganador
			j1.incrementarPuntuacion();
		}else j2.incrementarPuntuacion();
				
		return ganador + "\n" + "Nueva puntuacion de " + j1.getNombre() + ": " + j1.getPuntuacion() + "\n" + "Nueva puntuacion de " + j2.getNombre() + ": " + j2.getPuntuacion();
	}
}
