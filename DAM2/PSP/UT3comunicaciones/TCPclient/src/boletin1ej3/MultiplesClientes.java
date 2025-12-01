package boletin1ej3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiplesClientes {
	private int serverPort;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	
	public MultiplesClientes(int serverPort) {
		this.serverPort = serverPort;
	}
	
	public void start() throws UnknownHostException, IOException {
		System.out.println( "(Cliente) -> Estableciendo conexión...");
		socket = new Socket(InetAddress.getLocalHost(), serverPort);
		is = new DataInputStream(socket.getInputStream());
		os = new DataOutputStream(socket.getOutputStream());
		System.out.println( "(Cliente) -> Conexión establecida.");
	}
	
	public void stop() throws IOException {
		System.out.println("(Cliente) -> Cerrando conexiones.");
		is.close();
		os.close();
		socket.close();
		System.out.println("(Cliente) -> Conexiones cerradas.");
	}
	
	public static void main(String[] args) {
		/*ACTIVIDAD 3
		Crea un programa servidor que pueda atender hasta 3 clientes. Debe enviar a
		cada cliente un mensaje indicando el número de cliente que es empezando en
		1. Este número será 1, 2 o 3. El cliente mostrará el mensaje recibido: Cliente
		número: 1, Cliente número: 2 o Cliente número: 3. Cambia el programa para que
		lo haga para N clientes, siendo N un parámetro que tendrás que definir en el
		programa en el args del main. Utiliza protocolo TCP.*/
		
		MultiplesClientes cliente = new MultiplesClientes(49171);
		
		try {
			cliente.start();
			int numeroCliente = cliente.is.readInt();
			System.out.println("Cliente número " + numeroCliente);
			cliente.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
