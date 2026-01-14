package adivina_color;

public class App {

	public static void main(String[] args) {
		/*Crear un juego de trivia en Java donde varios clientes compiten para responder preguntas.
		Descripción:
		El servidor mantiene una lista de preguntas y respuestas.
		Los clientes envían sus respuestas por TCP al servidor.
		El servidor envía por UDP la puntuación actual a cada cliente después de cada ronda (rápido, sin conexión).
		Al final de cada ronda, el servidor anuncia el ganador de la ronda mediante Multicast a todos los clientes.
		Los clientes pueden ver sus puntuaciones, los intentos de otros y el ganador en tiempo real.
		Detalles técnicos:
		TCP → comunicación confiable uno a uno (respuestas de los clientes).
		UDP → información rápida sobre puntuación al final de ronda (no se asegura entrega).
		Multicast → anuncio del ganador a todos los clientes y anuncio fin del programa*/

		int portTCP = 3020;
		int portUDPserver = 4040;
		int portMulticast = 4060;
		int nClientes = 1;
		String serverIP = "127.0.0.1";
		String multicastIP = "224.0.0.2";
		
		new Server(portTCP, portUDPserver, portMulticast, multicastIP, nClientes).start();
		
		//esperamos a que el serviudor arranque o lanzara conection refusred
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new ClientListenerThread(portMulticast, multicastIP).start();

		
		for (int i = 0; i< nClientes; i++) {
			new ClientPlayerThread(portTCP, portUDPserver, serverIP).start();
		}
		
	}

}
