package appMulticast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private Server server;
	
	public ServerThread(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
	}
	
	@Override 
	public void run() {
		jugar();
		parar();
	}

	public void jugar() {
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			
			dos.writeUTF("Bienvenido jugador, cual es tu nombre?");
			String nombreJugador = dis.readUTF();
			int numeroGanador = (int)(Math.random() * 11);
			
			boolean continuar = true;
			boolean primerIntento = true;
			do {
				if (primerIntento) {
					dos.writeUTF("Bien " + nombreJugador + " introduce un numero entero entre 0 y 10 ambos inclusive");
					primerIntento = false;
				} else {
					dos.writeUTF("Incorrecto, introduce un nuevo numero");
				}
				
				int numero = dis.readInt();
				if (numero == numeroGanador) {
					dos.writeUTF("Enhorabuena " + nombreJugador + " has ganado!, fin del juego");
					server.emitirGanador(nombreJugador);
					continuar = false;
				}
			}while (continuar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parar() {
		try {
			dis.close();
			dos.close();
			socket.close();
			System.out.println("(ServidorThread) - Conexionces TCP cerradas");
		} catch (IOException e) {
			System.out.println("(ServidorThread-ERROR) - Error al cerrar conexiones " + e.getMessage());
		}
	}
	
}
