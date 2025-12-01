package boletin1ej3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiplesClientes {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	private static int numeroClientes;
	
	public MultiplesClientes(int puerto) throws IOException {
		serverSocket = new ServerSocket(puerto);
	}
	
	public void start() throws IOException {
		System.out.println("(Servidor) -> Esperando conexiones...");
		socket = serverSocket.accept();
		is = new DataInputStream(socket.getInputStream());
		os = new DataOutputStream(socket.getOutputStream());
		System.out.println("(Servidor) Conexión establecida.");
		numeroClientes++;
	}
	
	public void stop() throws IOException {
		System.out.println("(Servidor) -> Cerrando conexiones...");
		is.close();
		os.close();
		socket.close();
		System.out.println("(Servidor) -> Conexiones cerradas");
	}
	
	public static void main(String[] args) {
		/*ACTIVIDAD 3
		Crea un programa servidor que pueda atender hasta 3 clientes. Debe enviar a
		cada cliente un mensaje indicando el número de cliente que es empezando en
		1. Este número será 1, 2 o 3. El cliente mostrará el mensaje recibido: Cliente
		número: 1, Cliente número: 2 o Cliente número: 3. Cambia el programa para que
		lo haga para N clientes, siendo N un parámetro que tendrás que definir en el
		programa en el args del main. Utiliza protocolo TCP.*/
		
		try {
			MultiplesClientes servidor = new MultiplesClientes(49171);
			do {
				servidor.start();
				servidor.os.writeInt(numeroClientes);
			}while (numeroClientes < 3);	//Integer.parseInt(args[0])
			servidor.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
