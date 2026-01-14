package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCine {

    public static void main(String[] args) {
		try (Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
			
			System.out.println("Conectado al servidor de CineDAM en localhost:8888");
			Scanner sc = new Scanner(System.in);
			boolean salir = false;
			
			while (!salir) {
				System.out.println("\n--- MENÚ CINE ---");
				System.out.println("1. Ver Estado de Butacas");
				System.out.println("2. Reservar Butaca");
				System.out.println("3. Salir");
				System.out.print("Elige una opción: ");
				
				if (sc.hasNextInt()) {
					int opcion = sc.nextInt();
					
					switch (opcion) {
					case 1: // VER
						dos.writeInt(opcion);
						
						String respuestaEstado = dis.readUTF();
						System.out.println("SERVIDOR RESPONDIO:\n" + respuestaEstado);
						break;
						
					case 2: // RESERVAR
						dos.writeInt(opcion);
						
						System.out.print("Introduce número de butaca (1-5): ");
						if (sc.hasNextInt()) {
							int butaca = sc.nextInt();
							dos.writeInt(butaca);
							
							String respuestaReserva = dis.readUTF();
							System.out.println("SERVIDOR RESPONDIO: " + respuestaReserva);
						} else {
							System.out.println("Error: Debes introducir un número.");
							sc.next(); // Limpiar buffer
						}
						break;
						
					case 3: // SALIR
						dos.writeInt(opcion);
						salir = true;
						System.out.println("Cerrando aplicación...");
						break;
						
					default:
						System.out.println("Opción no válida.");
					}
				} else {
					System.out.println("Error: Introduce un número válido.");
					sc.next(); // Limpiar buffer del scanner
				}
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("ERROR- No se pudo leer del flujo" + e.getMessage());
			e.printStackTrace();
		}
    }
}