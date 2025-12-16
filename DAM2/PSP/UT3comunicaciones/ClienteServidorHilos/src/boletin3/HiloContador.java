package boletin3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class HiloContador extends Thread{
	private Socket socket;
	private OutputStreamWriter out;
	private BufferedWriter escritor;
	
    public HiloContador(Socket socket) {
        this.socket = socket;
    }

    private void inicializarStreams() throws UnsupportedEncodingException, IOException {
    	// Uso de streams de caracteres con UTF-8
    	out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
    	// Buffering para lectura y escritura de líneas eficiente
    	escritor = new BufferedWriter(out);
    }
    
    private void procesarPeticion() throws IOException {
    	synchronized (ServidorContador.class) {
			ServidorContador.incrementContadorVisitas();
			// Enviar mensaje inicial
			escritor.write("Bienvenido al servidor, eres el cliente número: " + ServidorContador.getContadorVisitas());
			escritor.flush(); // ¡FLUSH es CRUCIAL!
		}
    }
    
    private void cerrarConexion() throws IOException {
    	out.close();
    	escritor.close();
    	socket.close();
    }
    
    @Override
    public void run() {
        try {
        	inicializarStreams();
        	procesarPeticion();
            cerrarConexion();
            System.out.println("Cliente desconectado.");
        } catch (IOException e) {
            // Se maneja la excepción del hilo para evitar que caiga el servidor
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        }
    }
}
