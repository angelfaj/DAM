package adivina_color;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
	private ServerSocket serverSocket;
	private int portTCP;
	private int portUDP;

	private MulticastSocket multiSocket;
	private NetworkInterface interfaz;
	private InetAddress grupo;
	private DatagramPacket dPacket;
	private byte[] buffer;
	
	private int nClientes;
	private ArrayList<ServerThread> hilos = new ArrayList<ServerThread>();
	
	public final String[] preguntas = {
	        "¿Cuál es la capital de Francia?",
	        "¿Cuántos planetas hay en el sistema solar?",
	        "¿Quién escribió 'Cien años de soledad'?",
	        "¿Cuál es el elemento químico con símbolo 'O'?",
	        "¿En qué año llegó el hombre a la Luna?",
	        "¿Cuál es el animal terrestre más rápido del mundo?",
	        "¿Qué instrumento musical tiene teclas blancas y negras?",
	        "¿Cuál es la moneda de Japón?",
	        "¿Quién pintó la Mona Lisa?",
	        "¿Cuál es el océano más grande del mundo?"
	    };

    public final String[] respuestas = {
        "París",
        "8",
        "Gabriel García Márquez",
        "Oxígeno",
        "1969",
        "Guepardo",
        "Piano",
        "Yen",
        "Leonardo da Vinci",
        "Pacífico"
    };
	

	public Server(int portTCP, int portUDP, int nClientes) {
		this.portTCP = portTCP;
		this.portUDP = portUDP;
		this.nClientes = nClientes;
	}
	
	private void arrancar() throws IOException {
		//Multicast
		multiSocket = new MulticastSocket(portUDP);
		interfaz = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		grupo = InetAddress.getByName("235.10.10.1");
		multiSocket.setNetworkInterface(interfaz);
		
		//TCP
		serverSocket = new ServerSocket(portTCP);
		for (int i = 0; i < nClientes; i++) {
			Socket socket = serverSocket.accept();
			ServerThread hilo = new ServerThread(portUDP, socket, this);
			hilo.start();
			hilos.add(hilo);
		}
		
	}
	
	public void comunicarFinPuntuacion(String clientName, int points) {
		try {
			String mensajeFin = "El jugador " + clientName + " ha conseguido " + points + " puntos. Felicitaciones";
			buffer = mensajeFin.getBytes();
			
			dPacket = new DatagramPacket(buffer, buffer.length, grupo, portUDP);
			multiSocket.send(dPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void comunicarFinPuntuacion() {
		try {
			String mensajeFin = "Se acabaron las preguntas. FIN del programa.";
			buffer = mensajeFin.getBytes();
			
			dPacket = new DatagramPacket(buffer, buffer.length, grupo, portUDP);
			multiSocket.send(dPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void parar() throws IOException {
		//Esperamos a que terminen todos los hilos
		for (ServerThread hilo : hilos) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Comunicamos fin del programa por muklticast para que el listener se pare
		comunicarFinPuntuacion();
		
		//Cerramos coms
		if (!serverSocket.isClosed() && serverSocket != null) serverSocket.close();
		if (multiSocket != null && !multiSocket.isClosed()) multiSocket.close();
		
		System.out.println("(Servidor) - Comunicaciones cerradas");
	}
	
	@Override
	public void run() {
		try {
			arrancar();
			parar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getPreguntas() {
		return preguntas;
	}
	
	public String[] getRespuestas() {
		return respuestas;
	}
	
}
 