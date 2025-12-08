package boletin2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteActivo {
	private final int PUERTO_UDP = 8080;
	private final int PUERTO_TCP = 9000;
	private final String IP_GRUPO = "235.10.10.1";
	//Si el cliente está en otra máquina, esta IP debe ser la IP de su interfaz en la misma subred.
//	private final String IP_INTERFAZ_LOCAL = "192.168.56.1"; 
	
	private MulticastSocket socketUDP;
	private InetAddress grupo;
	private byte[] buffer = new byte[1024];
	private NetworkInterface interfaz;
	private Socket socketTCP;
	private DataInputStream is;
	private DataOutputStream os;
	
	

	public void arrancar() {
	    try {
	        // 1. Obtener la NetworkInterface a partir de la dirección IP local
	        InetAddress direccionLocal = InetAddress.getLocalHost();
	        interfaz = NetworkInterface.getByInetAddress(direccionLocal);

	        // 2. Inicializar el Socket y el Grupo
	        socketUDP = new MulticastSocket(PUERTO_UDP);
	        grupo = InetAddress.getByName(IP_GRUPO);
	        
	        // 3. Unirse al grupo multicast usando la interfaz específica. A partir de Java14 joinGroup(InetAddress) está en desuso
	        socketUDP.joinGroup(new InetSocketAddress(grupo, PUERTO_UDP), interfaz);
	        
	        // 4. Conexion TCP
	        System.out.println("(Cliente) Estableciendo conexión TCP");
	        socketTCP = new Socket(direccionLocal, PUERTO_TCP);
	        os = new DataOutputStream(socketTCP.getOutputStream());
	        is = new DataInputStream(socketTCP.getInputStream());
	        System.out.println("(Cliente) Conexión TCP establecida");

	        System.out.println("Cliente arrancado. Grupo: " + grupo.getHostAddress() + ", Puerto: " + PUERTO_UDP);
	        System.out.println("Usando interfaz para RECIBIR: " + interfaz.getDisplayName() + " (" + direccionLocal.getHostAddress() + ")");
	        
	    } catch (IOException e) {
	        System.err.println("Error al arrancar el cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	public void parar() {
		try {
			is.close();
			os.close();
			socketTCP.close();
			System.out.println("(Cliente) Conexión TCP cerranda");
			if (socketUDP != null && !socketUDP.isClosed()) {
				// Dejamos el grupo (con version de interfaz)
				socketUDP.leaveGroup(new InetSocketAddress(grupo, PUERTO_UDP), interfaz);
				socketUDP.close();
				System.out.println("Cliente UDP salió del grupo multicast y cerró el socket.");
			}
		} catch (IOException e) {
			System.err.println("Error al detener el cliente: " + e.getMessage());
		}
	}


	public void recibirMensajes() {
		try {
			DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
			
			// El socket se bloquea esperando un paquete
			socketUDP.receive(paqueteRecibido);

			String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
			System.out.println("--> Mensaje recibido por multicast: " + mensaje);
		} catch (IOException e) {
			// Si la excepción ocurre porque se llamó a parar() (cierre limpio), se ignora.
			if (!socketUDP.isClosed()) {
				System.err.println("Error en la recepción de mensajes: " + e.getMessage());
				e.printStackTrace();
			} else {
				System.out.println("Fin de la escucha: Socket cerrado.");
			}
		} 
	}
	
	public void consultarStockPorId(String id) throws IOException {
		os.writeUTF("CONSULTA:" + id);
	}

	public static void main(String[] args) throws UnknownHostException {
		Scanner sc = new Scanner(System.in);
		ClienteActivo cliente = new ClienteActivo();
		
		try {
			cliente.arrancar();
			String entrada = "";
			
			do {
				System.out.print("Introduce un id(entre 1 y 3, fin para terminar): ");
				entrada = sc.nextLine();
				cliente.consultarStockPorId(entrada);
				if (!entrada.equalsIgnoreCase("fin")) 
					cliente.recibirMensajes();
			}while (!entrada.equalsIgnoreCase("fin"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cliente.parar();
		sc.close();
	}
}
