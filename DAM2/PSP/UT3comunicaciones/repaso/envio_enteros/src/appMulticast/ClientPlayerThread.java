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

public class ClientPlayerThread extends Thread{
	private int puertoUDP;
	private int puertoTCP;
	private String ip_grupo = "235.10.10.1";
	private MulticastSocket multicastSocket;
	private InetAddress grupo;
	private byte[] buffer;
	private NetworkInterface interfaz;
	private String serverIP;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public ClientPlayerThread(String serverIP, int puertoTCP, int puertoUDP) {
		this.serverIP = serverIP;
		this.puertoTCP = puertoTCP;
		this.puertoUDP = puertoUDP;
	}
	
	@Override
	public void run() {
		arrancar();
		jugar();
		parar();
	}
	
	private void jugar() {
		try {
			int n = (int)(Math.random() * 11);
			int m = (int)(Math.random() * 11);
			String nombre = "Manolito-" + n + m;
			
			System.out.println("(Cliente) - Leyendo: " + dis.readUTF());
			dos.writeUTF(nombre);
			System.out.println("(Cliente) - Leyendo: " + dis.readUTF());
			
			String respuesta = "";
			do {
				int numero = (int)(Math.random() * 11);
				dos.writeInt(numero);
				respuesta = dis.readUTF();
				System.out.println("(Cliente) - Leyendo: " + respuesta);
			}while (!respuesta.contains("fin"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void parar() {
		try {
			dos.close();
			dis.close();
			socket.close();
			if (multicastSocket != null && !multicastSocket.isClosed()) {
				multicastSocket.leaveGroup(new InetSocketAddress(grupo, puertoUDP), interfaz);
				multicastSocket.close();
			}
			System.out.println("(Cliente) - Conexiones cerradas");
		} catch (IOException e) {
			System.out.println("(Cliente-ERROR) - Se produjo un error al cerrar las conexiones " + e.getMessage());
		}
	}

	private void arrancar() {
		try {
			socket = new Socket(serverIP, puertoTCP);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			multicastSocket = new MulticastSocket(puertoUDP);
			interfaz = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			grupo = InetAddress.getByName(ip_grupo);
			
			multicastSocket.joinGroup(new InetSocketAddress(grupo, puertoUDP), interfaz);
			
		} catch (IOException e) {
			System.out.println("(Cliente-ERROR) - Se produjo un error al arancar el cliente " + e.getMessage());
		}
	}
	
}
