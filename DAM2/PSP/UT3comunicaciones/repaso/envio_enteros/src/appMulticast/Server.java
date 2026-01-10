package appMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
	private ServerSocket serverSocket;
	private int puertoTCP;
	
	private NetworkInterface interfaz;
	private InetAddress grupo;
	private final String IP_GRUPO = "235.10.10.1";
	private int puertoUDP;
	private MulticastSocket multicastSocket;
	
	private int nClients;
	private ArrayList<ServerThread> hilosActivos = new ArrayList<ServerThread>();
	
	public Server(int puertoTCP, int puertoUDP, int nClients) throws IOException {
		this.puertoTCP = puertoTCP;
		this.puertoUDP = puertoUDP;
		this.nClients = nClients;
		multicastSocket = new MulticastSocket(puertoUDP);
		serverSocket = new ServerSocket(puertoTCP);
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
	
	private void arrancar() throws IOException {
		//Parte multicast
		interfaz = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		multicastSocket.setNetworkInterface(interfaz);
		grupo = InetAddress.getByName(IP_GRUPO);
		
		//Parte TCP
		for (int i = 0; i<nClients; i++) {
			Socket socket = serverSocket.accept();
			System.out.println("(Servidor) - Conexion establecida");
			ServerThread hilo = new ServerThread(socket, this);
			hilosActivos.add(hilo);
			hilo.start();
		}
	}
	
	private void parar() {
			try {
				for (ServerThread hilo:hilosActivos) {
					//Esperamos a que termine cada hilo para cerrar conexiones
					hilo.join();
				}
				if (multicastSocket != null && !multicastSocket.isClosed()) multicastSocket.close();
				if (serverSocket != null) serverSocket.close();
				System.out.println("(Servidor) - Conexiones cerradas");
			} catch (IOException e) {
				System.out.println("(Servidor-ERROR) - Error al cerrar las conexiones");
				e.printStackTrace();
			} catch (InterruptedException e) {
				System.out.println("(Servidor-ERROR) - Error al esperar hilo" + e.getMessage());
			}
	}
	
	public void emitirGanador(String ganador) {
		String msg  = "(Servidor) - El jugador " + ganador + " se ha llevado un premio!!";
		byte[] data = msg.getBytes();
		DatagramPacket datagram = new DatagramPacket(data, data.length, grupo, puertoUDP);
		try {
			multicastSocket.send(datagram);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
