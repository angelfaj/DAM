package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread{
	private Socket socket;
	private Servidor servidor;
	private int numeroCliente;
	
	public HiloCliente(Socket socket, Servidor servidor, int numeroCliente) {
		this.socket = socket;
		this.servidor = servidor;
		this.numeroCliente = numeroCliente;
	}
	
	private void atender() {
		try (DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){

			boolean continuar = true; 
			
			while (continuar) {
				int opcion = dis.readInt();
				
				switch (opcion) {
				case 1:	//Mostrar
					System.out.println("Cliente " + numeroCliente + " solicita la opcion " + opcion);
					String msg = servidor.getButacas();
					dos.writeUTF(msg);
					break;
					
				case 2: //Reservar
					System.out.println("Cliente " + numeroCliente + " solicita la opcion " + opcion); 
					int n = dis.readInt();
					
					if (servidor.reservarButaca(n)) {
						System.out.println("Butaca " + n + " reservada por cliente " + numeroCliente);
						String respuesta = "Exito: Reserva confirmada para butaca " + n;
						dos.writeUTF(respuesta);
					}else {
						String respuesta = "Fallo: La butaca " + n + " ya está ocupada";
						dos.writeUTF(respuesta);
					}
					break;
					
				case 3: //Salir
					System.out.println("Cliente " + numeroCliente + " solicita la opcion " + opcion); 
					System.out.println("Cliente " + numeroCliente + " ha solicitado desconexion"); 
					continuar = false;
					break;
					
				default:
					System.out.println("Opción no válida.");
					break;
				}
				
			}
			
			
		} catch (EOFException e) {
			//Cliente desconectado abrutamente capturamos y no hacemos nada
			System.out.println("Conexion perdida con el cliente " + numeroCliente);
		} catch (IOException e) {
			System.out.println("ERROR- No se pudo crear la conexion" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void parar() {
		if (socket != null ) {
			try {
				socket.close();
				System.out.println("Cliente " + numeroCliente + " desconectado y recursos liberados");
			} catch (IOException e) {
				System.out.println("ERROR- Imposible cerrar el socket" + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		atender();
		parar();
	}
}
