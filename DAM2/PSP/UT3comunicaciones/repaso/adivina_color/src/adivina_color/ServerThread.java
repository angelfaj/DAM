package adivina_color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class ServerThread extends Thread{
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Server server;
	
	private DatagramPacket datPacket;
	private DatagramSocket datSocket;
	private int portUDP;
	private byte[] buffer;

	public ServerThread(int portUDP, Socket socket, Server server) {
		this.portUDP = portUDP;
		this.socket = socket;
		this.server = server;
	}
	

	public void mostrarPuntuaciones(String clientePuntuacion) {
		buffer = clientePuntuacion.getBytes();
	}
	
	private void arrancar() {
		try {
			//Inicializamos recursos
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			datSocket = new DatagramSocket(portUDP);
			datPacket = new DatagramPacket(buffer, buffer.length);
			
			//Recogemos nombre, ip y puerto del cliente
			dos.writeUTF("Bienvenido a Trivia, indica cual es tu nombre(x TCP y UDP)?");
			String nombreCliente = dis.readUTF();
			datSocket.receive(datPacket);
			InetAddress clientIP = datPacket.getAddress();
			int clientUDP = datPacket.getPort();
			
			//Comienza ronda de preguntas
			String[] preguntas = server.getPreguntas();
			String[] respuestas = server.getRespuestas();
			int puntuacion = 0;
			
			for (int i = 0; i < preguntas.length; i++) {
				//Pregunta
				dos.writeUTF("====Ronda " + (i+1) + " de " + preguntas.length + "====");
				dos.writeUTF(preguntas[i]);
				String respuesta = dis.readUTF();
				//Comprobacion
				if (respuesta.equalsIgnoreCase(respuestas[i])) {
					dos.writeUTF("Es correcto, +1 punto");
					puntuacion++;
				}else {
					dos.writeUTF("La respuesta correcta era: "+ respuestas[i]);
				}
				//Comunicamos puntuacion
				String puntosMsg = "Tu puntuacion es: " + puntuacion; 
				buffer = puntosMsg.getBytes();
				datPacket = new DatagramPacket(buffer, buffer.length, clientIP, clientUDP);
				datSocket.send(datPacket);
			}
			//Enviamos puntuacion final por multicast
			server.comunicarFinPuntuacion(nombreCliente, puntuacion);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void parar() {
		try {
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		arrancar();
		parar();
	}
}
