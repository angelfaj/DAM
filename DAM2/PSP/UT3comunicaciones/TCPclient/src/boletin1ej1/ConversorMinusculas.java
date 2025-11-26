package boletin1ej1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConversorMinusculas {
	private String serverIP;
	private int serverPort;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	
	public ConversorMinusculas(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println(" (Cliente) Estableciendo conexión...") ;
		socket = new Socket(serverIP, serverPort);
		is = new DataInputStream(socket.getInputStream());
		os = new DataOutputStream(socket.getOutputStream());
		System. out.println(" (Cliente) Conexión establecida.");
	}
	
	public void stop() throws IOException {
		System.out.println("(Cliente) Cerrando conexiones...");
		is.close();
		os.close();
		socket.close();
		System.out.println("(Cliente) Conexiones cerradas.");
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
		
		ConversorMinusculas cliente = new ConversorMinusculas ("192.168.1.34", 49171);
		try {
			cliente.start();
			String servidorMensaje = cliente.is.readUTF();
			System.out.println("Mensaje del servidor:" + servidorMensaje);
			cliente.os.writeUTF(servidorMensaje.toLowerCase());
			cliente.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}