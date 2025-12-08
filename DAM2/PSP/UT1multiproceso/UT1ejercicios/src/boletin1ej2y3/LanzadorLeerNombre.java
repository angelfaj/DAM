package boletin1ej2y3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LanzadorLeerNombre {

	public static void main(String[] args) {
		/*Ejercicio 3
		Haz un programa que ejecute el Ejercicio 2 LeerNombre.java. Utiliza el método
		waitFor() para comprobar el valor de salida del proceso que se ejecuta. Prueba la
		ejecución del programa dando valor a los argumentos del main() y sin darle valor.
		¿Qué valor devuelve waitFor() en un caso y en otro?
		*/
		
		File bin = new File("bin");
		ProcessBuilder pb = new ProcessBuilder("java", "boletin1ej2y3.LeerNombre", "Vanesa");
		
		//Asignamos el directorio al process builder
		pb.directory(bin);
		
		System.out.println("Dir de trabajo " + pb.directory().getAbsolutePath());
		
		try {
			//Iniciamos el proceso
			Process p = pb.start();
			//Capturamos el stream y leemos
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
			//Capturamos la salida
			int salidaError = p.waitFor();
			System.out.println("Salida del proceso " + salidaError);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
