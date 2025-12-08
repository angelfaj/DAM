package boletin2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class ClientePasivo {
	/*Enunciado: Sistema de Inventario (TCP/Multicast/SQLite)
	Objetivo:Implementar una arquitectura híbrida secuencial (sin hilos): un cliente (Activo)
	solicita información de inventario al servidor vía TCP. El servidor consulta una
	base de datos SQLite y, con la información, notifica el resultado mediante UDP
	Multicast a todos los clientes suscritos (incluyendo un cliente Pasivo y el propio
	cliente Activo).Debido a la restricción de no usar hilos, el servidor y los clientes operarán de
	forma bloqueante, atendiendo una solicitud a la vez. Requisitos de Configuración 
	Componente Protocolo / Tecnología Parámetro Valor
	Petición (Activo → Servidor) TCP Puerto TCP 9000
	Respuesta (Servidor → Clientes)
	UDP Multicast IP Grupo Multicast 235.10.10.1
	Respuesta (Servidor → Clientes)
	UDP Multicast Puerto Multicast 8080
	Persistencia SQLite (Embebida) Archivo DB inventario.db
	Red NetworkInterface IP Local
	Su IP de red interna o virtual (Ej.192.168.56.10).
	1. Tarea Preliminar: Base de Datos SQLite (Este código Java es el que debes ejecutar una vez en su proyecto de Eclipse
	para configurar la base de datos inventario.db en el servidor). Está disponible en InicializarBaseDatos.java
	ID NOMBRE STOCK
	1 Teclado Mecánico 50
	2 Mouse Óptico 120
	3 Monitor 24" 30
	2. Tarea Servidor: ServidorCentral.java (Sin Hilos)
	El servidor es totalmente secuencial. Acepta una conexión TCP, la procesa completamente y luego vuelve a esperar otra conexión.
	1. Bucle de Operación: Crea un ServerSocket en el puerto 9000. Entra en un bucle infinito que:
	o Acepta Petición (Bloqueante): Ejecuta serverSocket.accept() y espera al cliente activo.
	o Consulta SQLite: Lee la petición TCP (Ej: CONSULTA:2) y consulta la base de datos inventario.db.
	o Construcción de Respuesta: Genera la cadena de respuesta:
	ID:[ID]|NOMBRE:[NOMBRE]|STOCK:[STOCK].
	o Emisión Multicast: Abre un MulticastSocket, configura la
	NetworkInterface y envía la respuesta a 235.10.10.1:8080.
	o Cierre: Cierra la conexión TCP con el cliente activo y el MulticastSocket de envío.
	o Vuelve a accept() para esperar al siguiente cliente.
	3. Tarea Cliente 1: El Activo Solicitante (ClienteActivo.java)
	Este cliente realiza la petición TCP y luego se detiene para escuchar la respuesta Multicast.
	1. Petición TCP:
	o Pide al usuario el ID del producto.
	o Abre el Socket TCP y envía la petición (CONSULTA:[ID]).
	o Cierra el socket TCP.
	2. Recepción Multicast (Bloqueante):
	o Abre un MulticastSocket en el puerto 8080.
	o Configura la NetworkInterface y se une al grupo.
	o Ejecuta ms.receive(paquete) y se bloquea, esperando la respuesta.
	o Al recibir el paquete, imprime el resultado y se desconecta del grupo/socket.
	4. Tarea Cliente 2: El Pasivo Monitor (ClientePasivo.java)
	Este cliente solo escucha los anuncios, sin hacer peticiones.
	1. Recepción Multicast (Bloqueante):
	o El cliente solo se dedica a la escucha.
	o Abre el MulticastSocket, configura la NetworkInterface y se une al grupo.
	o Ejecuta ms.receive(paquete) y se bloquea, esperando el anuncio del servidor (que fue disparado por el ClienteActivo).
	o Imprime el resultado y se desconecta del grupo/socket.
	Prueba del Sistema
	El ejercicio se prueba de forma secuencial:
	1. Iniciar ServidorCentral.java (Se queda bloqueado en accept()).
	2. Iniciar ClientePasivo.java (Se queda bloqueado en receive()).
	3. Iniciar ClienteActivo.java (Envía TCP y se queda bloqueado en receive()).
	4. El Servidor atiende la petición y envía el Multicast, despertando a ambos clientes y finalizando la prueba.
	AMPLIACIÓN: no cierres conexión después de la primera petición del cliente, imagina que quiere hacer varias peticiones y cuando envíe FIN será cuando
	deban de cerrar las comunicaciones.*/
	
	private final int PUERTO_UDP = 8080;
	private final String IP_GRUPO = "235.10.10.1";
	//Si el cliente está en otra máquina, esta IP debe ser la IP de su interfaz en la misma subred.
//	private final String IP_INTERFAZ_LOCAL = "192.168.56.1"; 
	
	private MulticastSocket socket;
	private InetAddress grupo;
	private byte[] buffer = new byte[1024];
	private NetworkInterface interfaz;

	public void arrancar() {
	    try {
	        // 1. Obtener la NetworkInterface a partir de la dirección IP local
	        InetAddress direccionLocal = InetAddress.getLocalHost();
	        interfaz = NetworkInterface.getByInetAddress(direccionLocal);

	        // 2. Inicializar el Socket y el Grupo
	        socket = new MulticastSocket(PUERTO_UDP);
	        grupo = InetAddress.getByName(IP_GRUPO);
	        
	        // 3. Unirse al grupo multicast usando la interfaz específica. A partir de Java14 joinGroup(InetAddress) está en desuso
	        socket.joinGroup(new InetSocketAddress(grupo, PUERTO_UDP), interfaz);

	        System.out.println("Cliente arrancado. Grupo: " + grupo.getHostAddress() + ", Puerto: " + PUERTO_UDP);
	        System.out.println("Usando interfaz para RECIBIR: " + interfaz.getDisplayName() + " (" + direccionLocal.getHostAddress() + ")");
	        
	    } catch (IOException e) {
	        System.err.println("Error al arrancar el cliente: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	public void parar() {
		try {
			if (socket != null && !socket.isClosed()) {
				// Dejamos el grupo (con version de interfaz)
				socket.leaveGroup(new InetSocketAddress(grupo, PUERTO_UDP), interfaz);
				socket.close();
				System.out.println("Cliente UDP salió del grupo multicast y cerró el socket.");
			}
		} catch (IOException e) {
			System.err.println("Error al detener el cliente: " + e.getMessage());
		}
	}


	public void recibirMensajes() {
		try {
			boolean activo = true;
			while (activo) {
				DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
				
				// El socket se bloquea esperando un paquete
				socket.receive(paqueteRecibido);

				String mensaje = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
				System.out.println("--> Mensaje recibido por multicast: " + mensaje);

				if (mensaje.trim().equalsIgnoreCase("FIN")) {
					activo = false;
					System.out.println("Recibido mensaje 'FIN'. Finalizando recepción...");
					// Parar inmediatamente al recibir FIN
					parar(); 
				}
			}
		} catch (IOException e) {
			// Si la excepción ocurre porque se llamó a parar() (cierre limpio), se ignora.
			if (!socket.isClosed()) {
				System.err.println("Error en la recepción de mensajes: " + e.getMessage());
				e.printStackTrace();
			} else {
				System.out.println("Fin de la escucha: Socket cerrado.");
			}
		} 
	}

	public static void main(String[] args) {
		ClientePasivo cliente = new ClientePasivo();
		cliente.arrancar();
		cliente.recibirMensajes();
	}
}


