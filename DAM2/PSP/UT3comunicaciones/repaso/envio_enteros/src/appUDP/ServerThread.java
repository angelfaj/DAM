package appUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerThread extends Thread{
	private int port;
	private DatagramSocket socket;
	private DatagramPacket datagramaEntrada;
	private DatagramPacket datagramaSalida;
	private byte[] bufferLectura;
	private byte[] bufferEscritura;
	
	public ServerThread(int port) throws SocketException {
		this.port = port;
		socket = new DatagramSocket(port);
	}
	
	@Override
	public void run() {
		String msg;
		try {
			msg = getMessage();
			System.out.println("(Servidor) - Mensaje recibido: " + msg);
			msg += ", Hola cliente UDP";
			sendMessage(msg.replace("\0", ""));	//Sin replace se pierde la 2º parte del mensaje. 
			//Alternativa mas robusta, en los metodos hacer: 
			//return new String(datagramaEntrada.getData(), 0, datagramaEntrada.getLength();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (socket != null) closeComs();
	}
	
	public String getMessage() throws IOException {
		System.out.println("(Servidor) - Recibiendo datagrama");
		bufferLectura = new byte[64];
		datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
		socket.receive(datagramaEntrada);
		System.out.println("(Servidor) - Datagrama recibido");
		
		return new String(bufferLectura);
	}
	
	public void sendMessage(String msg) throws IOException {
		System.out.println("(Servidor) - Enviando datagrama");
		bufferEscritura = msg.getBytes();
		datagramaSalida = new DatagramPacket(bufferEscritura, bufferEscritura.length, datagramaEntrada.getAddress(), datagramaEntrada.getPort());
		socket.send(datagramaSalida);
		System.out.println("(Servidor) - Datagrama enviado");
	}
	
	public void closeComs() {
		socket.close();
		System.out.println("(Servidor) - Conexiones cerradas");
	}
	
}
