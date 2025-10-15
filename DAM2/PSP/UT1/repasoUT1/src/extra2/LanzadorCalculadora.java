package extra2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class LanzadorCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File bin = new File("bin");
		ProcessBuilder pb = new ProcessBuilder("java", "extra2.Calculadora");
		pb.directory(bin);
		
		Process p;
		
		try {
			p = pb.start();
			try(OutputStream os = p.getOutputStream();
				BufferedReader buff = new BufferedReader(new InputStreamReader(p.getInputStream()));
				Scanner sc = new Scanner(System.in)) {
				
				boolean continuar = true;
				while (continuar) {
					System.out.print("Introduce una operacion sencilla ejemplo de formato 4 + 5, FIN para terminar: ");
					String entrada = sc.nextLine();
					
					os.write((entrada + "\n").getBytes());
					os.flush();
					
					String salida;
					if (entrada.equals("FIN")) {
						continuar = false;
						
						while((salida = buff.readLine()) != null) {
							System.out.println(salida);
						}
					}else {
						salida = buff.readLine();
						System.out.println(salida);
					}
					
				}
			}
			int exitCode = p.waitFor();
			System.out.println("Fin del programa padre, codigo salida: " + exitCode);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
