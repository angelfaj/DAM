package boletin1ej2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NumeroCuadrado {
	private String serverIP;
	private int serverPort;
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;
	
	public NumeroCuadrado(String serverIP, int serverPort) {
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
		NumeroCuadrado cliente = new NumeroCuadrado("192.168.1.34", 49171);
		try {
			cliente.start();
			cliente.os.writeInt(10);
			int servidorMensaje = cliente.is.readInt();
			System.out.println("Mensaje del servidor:" + servidorMensaje);
			cliente.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
