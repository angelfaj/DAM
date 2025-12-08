package e5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LanzadorComprobadorArgumentos {
	
	public static void main(String[] args) {
		//Modificaremos el ejhercicio para redirigir la salida a un fichero 
		File bin = new File("bin");
		File errorFile = new File("errores.txt");
		File salida = new File("salidaE5.txt");
		
		//Redireccion del processbuilder
//		String[] opciones = {"-2", "4", "Hello World!", "4 4"};
//		for (int i = 0; i < opciones.length; i++) {
//			ProcessBuilder pb = new ProcessBuilder();
//			pb.directory(bin);
//			pb.command("java", "e5.ComprobadorArgumentos", opciones[i]);
//			pb.redirectError(errorFile);
//			pb.redirectOutput(ProcessBuilder.Redirect.appendTo(salida));
//			Process p;
//			
//			try {
//				p = pb.start();
//				int codigoSalida = p.waitFor();
//				System.out.println("Codigo salida: " + codigoSalida);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		//Redireccion de process
		ProcessBuilder pb = new ProcessBuilder();
		pb.directory(bin);
		pb.command("java", "e5.ComprobadorArgumentos");
		pb.redirectError(errorFile);
		
		Process p;
		
		try {
			p = pb.start();
			InputStream is = p.getInputStream();
			
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char)c);
			}
			is.close();
			int codigoSalida = p.waitFor();
			System.out.println("Codigo salida: " + codigoSalida);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
