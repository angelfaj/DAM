package appTCP;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		//Ejercicio de repaso basico TCP, cliente escribe 100 servidor devuelve 200
		String serverIP = "127.0.0.1";
		int serverPort = 50000;
		
		ClientThread client = new ClientThread(serverIP, serverPort);
		ServerThread server = null;
		
		try {
			server = new ServerThread(serverPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		server.start();
		client.start();
	}

}
