package appMulticast;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		/* Crea un servidor donde cada cliente pueda jugar de forma independiente a
		adivinar un número secreto. El servidor principal debe generar un número
		aleatorio nuevo para cada cliente. La lógica del juego (en el servidor y en el
		cliente) y la gestión de la conexión deben ser modularizadas usando métodos
		auxiliares para mejorar la estructura del código*/
		
		int nPlayers = 2;
		int puertoTCP = 40040;
		int puertoUDP = 20040;
		String serverIP = "127.0.0.1";
		
		try {
			new Server(puertoTCP, puertoUDP, nPlayers).start();;
			new ClientListenerThread(puertoUDP, nPlayers).start();
			for (int i = 0; i<nPlayers; i++) {
				new ClientPlayerThread(serverIP, puertoTCP, puertoUDP).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
