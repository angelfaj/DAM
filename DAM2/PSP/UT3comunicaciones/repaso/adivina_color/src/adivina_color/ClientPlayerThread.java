package adivina_color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ClientPlayerThread extends Thread{
	private int portTCP;
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private String serverIP;

	private int portUDP;
	private byte[] buff;
	private DatagramSocket dSocket;
	private DatagramPacket dPacket;
	
	public ClientPlayerThread(int portTCP, int portUDP, String serverIP) {
		this.portTCP = portTCP;
		this.portUDP = portUDP;
		this.serverIP = serverIP;
	}
	
	private void arrancar() {
		try {
			//TCP
			socket = new Socket(serverIP, portTCP);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			//UDP
			dSocket = new DatagramSocket(portUDP);
			
			//Leemos peticion y enviamos nombre por TCP 
			String  solicitaNombre = dis.readUTF();
			System.out.println("(Cliente-Lee)- " + solicitaNombre);
			int n = (int) Math.random() * 11;
			String nombre = "Rebeca-"+n;
			dos.writeUTF(nombre);
			
			//Enviamos nombre por UDP 
			buff = nombre.getBytes();
			dPacket = new DatagramPacket(buff, buff.length, InetAddress.getByName(serverIP), portUDP);
			dSocket.send(dPacket);
			
			//A jugarrr
			int ñapa = 10;//mismo numero que preguntas.length(servidor)
			for (int i = 0; i < ñapa; i++) {
				//Leemos pregunta e imprimimos
				String pregunta = dis.readUTF();
				System.out.println("(Cliente-Lee)- " + pregunta);
				
				//Enviamos respuesta
				dos.writeUTF("Ni idea Julio");
				
				//Leemos respuesta
				String respuestaServidor = dis.readUTF();
				System.out.println("(Cliente-Lee)- " + respuestaServidor);
				
				//Leemos puntuacion por UDP
				buff = new byte[128];
				dPacket = new DatagramPacket(buff, buff.length, InetAddress.getByName(serverIP), portUDP);
				dSocket.receive(dPacket);
				
				//Mostramos puntuacion leida
				String puntuacion = new String(buff, 0, buff.length);
				System.out.println("(Cliente-Lee)- " + puntuacion);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void parar() {
		try {
			dis.close();
			dos.close();
			if (socket != null && !socket.isClosed()) socket.close();
			if (dSocket != null && !dSocket.isClosed()) dSocket.close();
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
