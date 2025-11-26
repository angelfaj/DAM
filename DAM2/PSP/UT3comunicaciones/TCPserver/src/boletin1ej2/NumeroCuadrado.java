package boletin1ej2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import boletin1ej1.ConversorMinusculas;

public class NumeroCuadrado {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	
	//por defecto se asigna la ip de la maquina y un puerto
	public NumeroCuadrado(int puerto) throws IOException {
		serverSocket = new ServerSocket (puerto) ;
	}
	
	public void start() throws IOException {
		System.out.println(" (Servidor) Esperando conexiones...");
		socket = serverSocket.accept();
		is = new DataInputStream(socket.getInputStream());
		os = new DataOutputStream(socket.getOutputStream());
		System.out.println(" (Servidor) Conexión establecida.");
	}
	
	public void stop() throws IOException {
		System.out.println(" (Servidor) Cerrando conexiones…");
		is.close();
		os.close();
		socket.close();
		serverSocket.close();
		System.out.println(" (Servidor) Conexiones cerradas…");
	}

	public static void main(String[] args) {
		/*ACTIVIDAD 2
		Crea un programa cliente que introduzca por teclado un número entero y se lo
		envíe al servidor. El servidor le devolverá el cuadrado del número. Ves
		mostrando por pantalla lo que se envía/recibe tanto en la parte de servidor como
		en la parte cliente para comprobar que sale/entra la información correctamente
		según corresponda. Utiliza protocolo TCP.
		• Para leer y escribir números en los flujos de entrada/salida utiliza los
		constructores del ejercicio 1 (DataInputStream y DataOutputStream) pero
		usa los métodos readInt() y writeInt(num).
		• Utiliza la clase InetAddress para indicar en el cliente que se va a conectar
		con “localhost”.*/
		try {
			NumeroCuadrado servidor = new NumeroCuadrado(49171);
			servidor.start();
			int mensajeCliente = servidor.is.readInt();
			servidor.os.writeInt(mensajeCliente * mensajeCliente);
			System.out.println("Mensaje del cliente:" + mensajeCliente);
			servidor.stop();
		}catch (IOException ioe) {
			ioe.printStackTrace ();
		}

	}

}
