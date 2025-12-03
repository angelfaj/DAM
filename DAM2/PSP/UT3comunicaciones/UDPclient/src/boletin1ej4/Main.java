package boletin1ej4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
	private DatagramSocket socket;
	private DatagramPacket peticion;
	private DatagramPacket respuesta;
	private byte[] bufferArr = new byte[64];
	private byte[] mensajeArr;
	private InetAddress serverHost;
	private int serverPort;
	
	public Main(int serverPort) throws UnknownHostException {
		this.serverPort = serverPort;
		serverHost = InetAddress.getByName("localhost");
	}
	
	public void start() throws SocketException {
		System.out.println("(Cliente) -> Creando socket...");
		socket = new DatagramSocket();
	}
	
	public void enviar(String mensaje) throws IOException {
		System.out.println("(Cliente) -> Enviando datagrama...");
		mensajeArr = mensaje.getBytes();
		peticion = new DatagramPacket(mensajeArr, mensajeArr.length, serverHost, serverPort);
		socket.send(peticion);
		System.out.println("(Cliente) -> Datagrama enviado.");
	}
	
	public void recibir() throws IOException {
		bufferArr = new byte[64];
		System.out.println("(Cliente) -> Recibiendo datagrama...");
		respuesta = new DatagramPacket(bufferArr, bufferArr.length, serverHost, serverPort);
		try {
			socket.setSoTimeout(4000);
			socket.receive(respuesta);
		}catch (InterruptedIOException e) {
			System.out.println("(Cliente) -> Paquete perdido.");
		}
		System.out.println("(Cliente) -> Mensaje recibido: " + new String(bufferArr));
	}
	
	public void stop() {
		System.out.println("(Cliente) -> Cerrando socket...");
		socket.close();
		System.out.println("(Cliente) -> Conexión cerrada.");
	}
	
	public static void main(String[] args) {
		/*ACTIVIDAD 4
		Crea un programa cliente usando sockets UDP que envíe el texto escrito desde
		la entrada estándar (System.in) al servidor. El servidor le devolverá la cadena en
		mayúsculas y lo mostrará por pantalla el cliente. El proceso de entrada de datos
		finalizará cuando el cliente introduzca un asterisco.
		Crea un programa servidor que reciba cadenas de caracteres del cliente, las
		muestre en pantalla y se las envíe al emisor (cliente) en mayúscula. El proceso
		servidor finalizará cuando reciba un asterisco.
		Establece un tiempo de espera de 5000 milisegundos con el método
		setSoTimeout(4000) para hacer que el método receive() del programa cliente
		se bloquee. Pasado ese tiempo controlar si no se reciben datos lanzando la
		excepción InterruptedIOException, en cuyo caso visualiza un mensaje
		indicando que el paquete se ha perdido. Para probarlo ejecuta el programa
		cliente sin ejecutar el servidor.*/
		
		try {
			Main cliente = new Main(49172);
			Scanner sc = new Scanner(System.in);
			String m = "";
			
			cliente.start();
			do {
				System.out.print("Introduce el mensaje a enviar: ");
				m = sc.nextLine();
				cliente.enviar(m);
				cliente.recibir();
			}while (!m.equals("*"));
			cliente.stop();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
