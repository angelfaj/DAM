package boletin1ej4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
	private DatagramSocket socket;
	private DatagramPacket datEntrada;
	private DatagramPacket datSalida;
	private byte[] bufferLectura = new byte[64];
	
	public Main(int puerto) throws SocketException {
		socket = new DatagramSocket(puerto);
	}
	
	public void start() {
		System.out.println("(Servidor) -> Creando datagrama de entrada...");
		datEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
		System.out.println("(Servidor) -> Datagrama creado.");
	}
	
	public String recibirDatagrama() throws IOException {
		socket.receive(datEntrada);
		System.out.println("(Servidor) -> Datagrama recibido.");
		
		return new String(bufferLectura);
	}
	
	public void enviarDatagrama(String mensaje) throws IOException {
		System.out.println("(Servidor) -> Creando datagrama de salida...");
		byte[] mensajeEnviado = mensaje.getBytes();
		datSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length, datEntrada.getAddress(), datEntrada.getPort());
		socket.send(datSalida);
		System.out.println("(Servidor) -> Datagrama Enviado.");
	}
	
	public void stop() {
		System.out.println("(Servidor) -> Cerrando socket...");
		socket.close();
		System.out.println("(Servidor) -> Conexión cerrada.");
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
			Main server = new Main(49171);
			String mensajeRecibido = "";
			server.start();
			do {
				mensajeRecibido = server.recibirDatagrama();
				System.out.println("(Servidor) -> Mensaje recibido: " + mensajeRecibido);
	
				if (!mensajeRecibido.equals("*")) server.enviarDatagrama(mensajeRecibido.toUpperCase());

			}while (!mensajeRecibido.equals("*"));
			
			server.stop();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
