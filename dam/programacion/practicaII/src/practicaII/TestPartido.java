package practicaII;

public class TestPartido {

	public static void main(String[] args) {
		//
		Jugador j1 = new Jugador("Rafael Nadal");			//usamos el primer constructor
		Jugador j2 = new Jugador("Roger Federer", 3800);	//usamos el segundo constructor
		
		Partido p1 = new Partido(j1, j2);
		
		j1.setPuntuacion(4000);								//Le añadimos ahora la puntuacion
		
		System.out.println(p1.mostrarInformacionJugadores());
		
		System.out.println(p1.jugar());
		
	}

}
