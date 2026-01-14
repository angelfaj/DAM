package adivina_color;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientListenerThread extends Thread{
	private MulticastSocket multicastSocket;
	private NetworkInterface interfaz;
	private int portUDP;
	private InetAddress grupo;
	private String ipMulticast;
	
	public ClientListenerThread(int portUDP, String ipMulticast) {
		this.portUDP = portUDP;
		this.ipMulticast = ipMulticast; 
	}
	
	private void arrancar() {
		try {
			//Instanciamos objetos y nos unimos al grupo
			multicastSocket = new MulticastSocket(portUDP);
			grupo = InetAddress.getByName(ipMulticast);
			interfaz = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			multicastSocket.joinGroup(new InetSocketAddress(grupo, portUDP), interfaz);
			
			//Quedamos a la escucha
			boolean continuar = true;
			while (continuar) {
				byte[] buff = new byte[128];
				DatagramPacket datEntrada = new DatagramPacket(buff, buff.length);
				multicastSocket.receive(datEntrada);
				String mensajeMulticast = new String(datEntrada.getData(), 0, datEntrada.getLength());
				
				if (mensajeMulticast.contains("FIN")) continuar = false;
				System.out.println("MULTICAST-" + mensajeMulticast);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void parar() {
		if (multicastSocket != null && !multicastSocket.isClosed()) multicastSocket.close();
		System.out.println("(Listener)-Comunicaciones cerradas");
	}
	
	@Override
	public void run() {
		arrancar();
		parar();
	}
	
}
