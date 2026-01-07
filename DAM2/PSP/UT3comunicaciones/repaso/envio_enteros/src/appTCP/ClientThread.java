package appTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread{
	private String serverIP;
	private int serverPort;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	
	public ClientThread(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	@Override
	public void run() {
		arrancar();
		try {
			os.writeUTF("Hola servidor");
			System.out.println("Mensaje del servidor: " + is.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parar();
	}
	
	private void arrancar() {
		System.out.println("(Cliente) - Estableciendo conexion");
		try {
			socket = new Socket(serverIP, serverPort);
			os = new DataOutputStream(socket.getOutputStream());
			is = new DataInputStream(socket.getInputStream());
			System.out.println("(Cliente) - Conexion establecida");
		} catch (IOException e) {
			System.out.println("(Cliente-ERROR) - Se produjo un error al realizar la conexion" + e.getMessage());
		}
	}
	
	private void parar() {
		System.out.println("(Cliente) - Cerrando conexiones");
		try {
			os.close();
			is.close();
			socket.close();
			System.out.println("(Cliente) - Conexiones cerradas");
		} catch (IOException e) {
			System.out.println("(Cliente-ERROR) - Se produjo un error al cerrar las conexiones" + e.getMessage());
		}
		
	}

}
