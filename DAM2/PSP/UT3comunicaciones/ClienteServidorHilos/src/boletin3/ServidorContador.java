package boletin3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorContador extends Thread{
	private static int contadorVisitas;
    private int puerto;
    
    public ServidorContador(int puerto) {
    	this.puerto = puerto;
    }

    @Override
    public void run() {
    	try (ServerSocket servidor = new ServerSocket(puerto)) {
    		System.out.println("Servidor esperando conexiones...");
    		aceptarPeticion(servidor);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void aceptarPeticion(ServerSocket servidor) throws IOException {
    	while (true) {
    		Socket socket = servidor.accept();
    		System.out.println("Cliente conectado: " + socket.getInetAddress());
    		// Lanza un nuevo hilo por cada cliente
    		new HiloContador(socket).start();
    	}
    }

	public static int getContadorVisitas() {
		return contadorVisitas;
	}
	
	public static void incrementContadorVisitas() {
		contadorVisitas++;
	}
}

