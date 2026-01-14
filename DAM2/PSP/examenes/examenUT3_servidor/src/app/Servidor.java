package app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
	private int puertoTCP;
	private ServerSocket serverSocket;
	
	private String[] butacas = new String[5];
	
	public Servidor(int puertoTCP) {
		this.puertoTCP = puertoTCP;
	}
	
	private void llenarButacas() {
		for (int i = 0; i < 5; i++) {
			String butaca = (i+1)+":Libre";
			butacas[i] = butaca;
		}
	}
	
	private void arrancar() {
		int nombreCliente = 5020;
		try {
			serverSocket = new ServerSocket(puertoTCP);
			System.out.println("--- CINE DAM: Servidor iniciado en puerto 8888 ---");
			System.out.println("Esperando clientes...");
			while (true) {
	
					Socket socket = serverSocket.accept();
					System.out.println("Nuevo cliente conectado desde: " + socket.getInetAddress());
					
					new HiloCliente(socket, this, nombreCliente).start();
					nombreCliente++;
				
			}
		} catch (IOException e) {
			System.out.println("ERROR- No se pudo lanzar el hilo" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String getButacas() {
		String txt = "";
		for (int i = 0; i < butacas.length; i++) {
			txt += "[" + butacas[i] + "] ";
		}
		return txt;
	}

	public synchronized boolean reservarButaca(int n) {	//Devuelve true si cambia el estado de la butaca
		int nButaca = n - 1;	
		String butacaSolicitada = butacas[nButaca];
		
		if (butacaSolicitada.contains("Libre")) {
			butacas[nButaca] = (n)+":Ocupada";
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		llenarButacas();
		arrancar();
	}
}
