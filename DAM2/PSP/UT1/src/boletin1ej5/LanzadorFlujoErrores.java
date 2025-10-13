package boletin1ej5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LanzadorFlujoErrores {

	public static void main(String[] args) {

		//Creamos objeto file y constructor
		File bin = new File("bin");
		ProcessBuilder pb = new ProcessBuilder("java", "boletin1ej5.FlujoErrores", "", "");
		
		//Asignamos directorio al constructor
		pb.directory(bin);
		
		try {
			//Iniciamos proceso y capturamos flujo de errores
			Process p = pb.start();
			InputStream is = p.getErrorStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
			
			int salidaErr = p.waitFor();
			System.out.println("Salida del proceso: " + salidaErr);
		}catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
