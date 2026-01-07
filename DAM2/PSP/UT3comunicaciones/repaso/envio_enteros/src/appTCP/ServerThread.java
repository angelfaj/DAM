package appTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	
	public ServerThread(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}
	
	@Override
	public void run() {
		arrancar();
		try {
			System.out.println("Mensaje del cliente: " + is.readUTF());
			os.writeUTF("Hola cliente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		parar();
	}
	
	private void arrancar() {
		System.out.println("(Servidor) - Esperando conexiones");
		try {
			socket = serverSocket.accept();
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());
			System.out.println("(Servidor) - Conexion establecida");
		} catch (IOException e) {
			System.out.println("(Servidor-ERROR) - Hubo un problema al establecer la conexion" + e.getMessage());
		}
	}
	
	private void parar() {
		System.out.println("(Servidor) - Cerrando conexiones");
		try {
			is.close();
			os.close();
			socket.close();
			System.out.println("(Servidor) - Conexiones cerradas");
		} catch (IOException e) {
			System.out.println("(Servidor-ERROR) - Hubo un problema al cerrar las conexiones" + e.getMessage());
		}
	}
}
