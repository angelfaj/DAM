package appMulticast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;

public class ClientListenerThread extends Thread{
	private int puertoUDP;
	private String ip_grupo = "235.10.10.1";
	private MulticastSocket multicastSocket;
	private InetAddress grupo;
	private byte[] buffer;
	private NetworkInterface interfaz;
	
	private int nPlayers;
	
	public ClientListenerThread(int puertoUDP, int nPlayers) {
		this.puertoUDP = puertoUDP;
		this.nPlayers = nPlayers;
	}
	
	@Override
	public void run() {
		arrancar();
		recibirMulticast();
		parar();
	}
	
	private void recibirMulticast() {
		for (int i = 0; i < nPlayers; i++) {
			buffer = new byte[1024];
			DatagramPacket datgram = new DatagramPacket(buffer, buffer.length);
			try {
				multicastSocket.receive(datgram);
				String multiMsg = new String(datgram.getData(), 0, datgram.getLength());
				System.out.println("MULTICAST-" + multiMsg);
			} catch (IOException e) {
				System.out.println("(ClienteListener) - Error en la recepcion multicast " + e.getMessage());
			}
		}
	}

	private void parar() {
		try {
			if (multicastSocket != null && !multicastSocket.isClosed()) {
				multicastSocket.leaveGroup(new InetSocketAddress(grupo, puertoUDP), interfaz);
				multicastSocket.close();
			}
			System.out.println("(ClienteListener) - Conexiones cerradas");
		} catch (IOException e) {
			System.out.println("(ClienteListener-ERROR) - Se produjo un error al cerrar las conexiones " + e.getMessage());
		}
	}

	private void arrancar() {
		try {
			multicastSocket = new MulticastSocket(puertoUDP);
			interfaz = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			grupo = InetAddress.getByName(ip_grupo);
			
			multicastSocket.joinGroup(new InetSocketAddress(grupo, puertoUDP), interfaz);
			
		} catch (IOException e) {
			System.out.println("(Cliente-ERROR) - Se produjo un error al arancar el cliente " + e.getMessage());
		}
	}
	
}