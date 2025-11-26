package boletin1ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConversorMinusculas {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	
	//por defecto se asigna la ip de la maquina y un puerto
	public ConversorMinusculas(int puerto) throws IOException {
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
		/*ACTIVIDAD 1
		Crea un programa servidor que envíe un mensaje a otro programa cliente y el
		programa cliente que le devuelva el mensaje en minúscula. Ves mostrando por
		pantalla el mensaje que envía/recibe tanto en la parte de servidor como en la
		parte cliente para comprobar que sale/entra el mensaje en
		mayúsculas/minúsculas según corresponda. Utiliza protocolo TCP.
		• Para mandar mensajes de texto (String) usa la clase DataOutputStream
		con el constructor DataOutputStream(OutputStream out). Utiliza el
		método writeUTF(sms).
		• Para leer mensajes de texto (String) usa la clase DataInputStream con el
		constructor DataInputStream(InputStream in). Utiliza el método
		readUTF().
		• Para aclarar ideas de flujos de entrada (Input) y salida (Output) puedes
		revisar el siguiente enlace:
		http://www.sc.ehu.es/sbweb/fisica/cursoJava/fundamentos/archivos/flujo
		s.htm#Escritura*/
		
		try {
			ConversorMinusculas servidor = new ConversorMinusculas(49171);
			servidor.start();
			servidor.os.writeUTF("HOLA CLIENTE");
			String mensajeCliente = servidor.is.readUTF();
			System.out.println("Mensaje del cliente:" + mensajeCliente);
			servidor.stop();
		}catch (IOException ioe) {
			ioe.printStackTrace ();
		}
	}
	
}