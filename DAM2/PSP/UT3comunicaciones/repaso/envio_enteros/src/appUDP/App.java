package appUDP;

import java.net.SocketException;
import java.net.UnknownHostException;

public class App {

	public static void main(String[] args) {
		//Ejercicio de repaso basico UDP. Cliente envia msg servidor responde msg+algo
		int serverPort = 50001;
		String serverIP = "127.0.0.1";
		ClientThread client;
		ServerThread server;
		try {
			 client = new ClientThread(serverIP, serverPort);
			 server = new ServerThread(serverPort);
			 client.start();
			 server.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
