package boletin1ej4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LanzadorJavaInexistente {

	public static void main(String[] args) {
		/*Ejercicio 4
		Partiendo del ejercicio 3, muestra por pantalla los errores que se producen al ejecutar
		un programa Java que no exista.
		*/
		
		//Creamos el archivo y el constructor de procesos
		File bin = new File("bin");
		ProcessBuilder pb = new ProcessBuilder("java", "nombreInventado");
		
		//Asignamos directorio al constructor
		pb.directory(bin);
		
		try {
			Process p = pb.start();
			InputStream is = p.getErrorStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
			//Capturamos salida de errores
			int salidaError = p.waitFor();
			System.out.println("Salida del proceso " + salidaError);
		}catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		

	}

}
