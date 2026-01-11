package appUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientThread extends Thread {
	private int serverPort;
	private int localPort = 50000;
	private InetAddress serverIP; 
	private DatagramSocket datagramSocket;
	private DatagramPacket datSalida;
	private DatagramPacket datEntrada;
	private byte[] buffEntrada;
	private byte[] buffSalida;
	
	public ClientThread(String serverIP, int port) throws SocketException, UnknownHostException {
		this.serverPort = port;
		this.serverIP = InetAddress.getByName(serverIP);
		datagramSocket = new DatagramSocket(localPort);
	}
	
	@Override
	public void run() {
		try {
			sendMsj("Hola servidor UDP");
			System.out.println("Mensaje del servidor: " + receiveMsj()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (datagramSocket!= null) closeComs();
	}
	
	private void sendMsj(String msj) throws IOException {
		System.out.println("(Cliente) - Enviando mensaje");
		buffSalida = msj.getBytes();
		datSalida = new DatagramPacket(buffSalida, buffSalida.length, serverIP, serverPort);
		datagramSocket.send(datSalida);
		System.out.println("(Cliente) - Mensaje enviado");
	}
	
	private String receiveMsj() throws IOException {
		System.out.println("(Cliente) - Recibiendo mensaje");
		buffEntrada = new byte[64];
		datEntrada = new DatagramPacket(buffEntrada, buffEntrada.length);
		datagramSocket.receive(datEntrada);
		System.out.println("(Cliente) - Mensaje recibido");
		
		return new String(buffEntrada);
	}
	
	private void closeComs() {
		datagramSocket.close();
		System.out.println("(Cliente) - Conexiones cerradas");
	}
	
}
