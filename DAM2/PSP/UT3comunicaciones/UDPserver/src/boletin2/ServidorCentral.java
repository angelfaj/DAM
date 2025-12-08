package boletin2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServidorCentral {
	private final int PUERTO_UDP = 8080;
	private final int PUERTO_TCP = 9000;
	private final String IP_GRUPO = "235.10.10.1";
	private InetAddress grupo;
	private MulticastSocket multicastSocket;
	private ServerSocket serverSocket;
	private Socket socket;
	private NetworkInterface interfaz;
	private DataInputStream is;
	private DataOutputStream os;
		
	public void arrancar() {
		try {
			// 1: Obtener la interfaz a paartir de la ip local
			interfaz = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			// 2. Inicializar socket y grupo
			multicastSocket = new MulticastSocket(PUERTO_UDP);
			grupo = InetAddress.getByName(IP_GRUPO);
			// 3. COnfigurar interfaz de envio
			multicastSocket.setNetworkInterface(interfaz);
			// 4. Conexion TCP
			serverSocket = new ServerSocket(PUERTO_TCP);
			System.out.println("(Servidor) Esperando conexiones entrantes");
			socket = serverSocket.accept();
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());
			System.out.println("(Servidor) conexión establecida");
			
			System.out.println("Servidor arrancado. Grupo: " + grupo.getHostAddress() + ", Puerto: " + PUERTO_UDP);
	        System.out.println("Usando interfaz de ENVÍO: " + interfaz.getDisplayName() + " (" + InetAddress.getLocalHost() + ")");
	        
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parar() {
		try {
			is.close();
			os.close();
			socket.close();
			serverSocket.close();
			System.out.println("(Servidor) Conexion TCP cerrada");
			if (multicastSocket != null && !multicastSocket.isClosed()) {
				multicastSocket.close();
				System.out.println("Servidor UDP detenido y socket cerrado.");
			}
		}catch (Exception e) {
			System.err.println("Error al detener el servidor: " + e.getMessage());
		}
	}
	
	public static Connection conectarSQLite() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:inventario.db";
			conn = DriverManager.getConnection(url);
			System.out.println("Conexion con SQLite realizada correctamente");
		}catch (SQLException e) {
			System.out.println("Error en la conexion: " + e.getMessage());
		}
		return conn;
	}
	
	public void enviarMensajeBienvenida() {
		try {
			String[] mensajes = { 
				"Aviso 1: Bienvenidos al servidor multicast",
				"FIN"
			};

			for (String msg : mensajes) {
				byte[] datos = msg.getBytes();
				DatagramPacket paquete = new DatagramPacket(datos, datos.length, grupo, PUERTO_UDP);

				multicastSocket.send(paquete);
				System.out.println("Mensaje multicast enviado: " + msg);

			}
			

		} catch (Exception e) {
			System.err.println("Error al enviar mensajes: " + e.getMessage());
			e.printStackTrace();
		} finally {
			parar();
		}
	}
	
	public String procesarPeticion(int id) {
		String sql = "SELECT * FROM PRODUCTOS WHERE ID =" + id;
		String respuestaServidor = "";
		
		try (Connection conn = conectarSQLite(); 
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
						
			while (rs.next()) {
				int idProducto = rs.getInt(1);
				String nombre = rs.getString(2);
				int stock = rs.getInt(3);
				respuestaServidor = "ID:" + idProducto + "|NOMBRE:" + nombre + "|STOCK:" + stock;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuestaServidor;
	}
	
	public void envioMensajeMulticast(String msg) throws IOException {
		byte[] datos = msg.getBytes();
		DatagramPacket paquete = new DatagramPacket(datos, datos.length, grupo, PUERTO_UDP);

		multicastSocket.send(paquete);
		System.out.println("Mensaje multicast enviado: " + msg);

	}
	
	public static void main(String[] args) {
		ServidorCentral servidor = new ServidorCentral();
		try {
			servidor.arrancar();
//			servidor.enviarMensajeBienvenida();
			String peticionCliente = "", respuestaServidor = "";
			do {
				String peticionRaw = servidor.is.readUTF();
				peticionCliente = peticionRaw.split(":")[1];

				if (!peticionCliente.trim().equalsIgnoreCase("FIN")) {
					int id = Integer.parseInt(peticionCliente);
					respuestaServidor = servidor.procesarPeticion(id);
					servidor.envioMensajeMulticast(respuestaServidor);
				}
			}while (!peticionCliente.trim().equalsIgnoreCase("FIN"));
			servidor.envioMensajeMulticast("FIN");	//Envio mensaje FIN para cliente pasivo
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		servidor.parar();
	}
}














