package boletin3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteContador extends Thread{
	private String host;
	private int puerto;
	private Socket socket; 
	private InputStreamReader in;
	private BufferedReader lector;
	
	public ClienteContador(String host, int puerto) {
		this.host = host;
		this.puerto = puerto;
	}

	private void conectar() throws UnknownHostException, IOException {
		socket = new Socket(host, puerto);
		in = new InputStreamReader(socket.getInputStream(), "UTF-8");
		lector = new BufferedReader(in);
	}
	
	private void leerMensajeInicial() throws IOException {
		// 1. Leer mensaje inicial del servidor
		System.out.println(lector.readLine());
	}
	
	private void ejecutarLogica() {
		//No hay logica ya que solo escucha
	}
	
	private void desconectar() throws IOException {
		socket.close();
		in.close();
		lector.close();
	}
	
	@Override
	public void run() {
		try {
			conectar();
			leerMensajeInicial();
			desconectar();
			System.out.println("--> Cliente desconectado.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				desconectar();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
