package boletin1ej10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		/*Ejercicio 10
		Crea un programa donde el proceso lea de un fichero de entrada las instrucciones
		siguientes:
		• Crea una carpeta que se llame MiCarpeta dentro del directorio del proyecto
		Java.
		• Crea un fichero que se llame ejercicio.txt que esté dentro de la carpeta creada
		en el paso anterior.
		• Incluye el siguiente texto dentro del fichero ejercicio.txt: “Esto es un ejercicio”
		Una vez finalizado y comprobado los resultados, modifica el programa anterior
		para que puedas añadir al fichero ejercicio.txt el texto “Esta es otra ejecución de mi
		ejercicio” una vez existen los ficheros y estructura de carpetas descritas
		anteriormente.
		*/
		
		File script = new File("script10.sh");
		File errorFile= new File("errores10.txt");
		File nuevoFile = new File("MiCarpeta/ejercicio.txt");
		
		ProcessBuilder pb = new ProcessBuilder("/bin/bash");
		
		pb.redirectInput(ProcessBuilder.Redirect.from(script));
		pb.redirectError(ProcessBuilder.Redirect.to(errorFile));
		
		try {
			Process p = pb.start();
			int i = p.waitFor();
			System.out.println(i);
			addToFile(nuevoFile, "Esta es otra ejecucion de mi ejercicio");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Segunda parte: añadir la linea con el metodo .command()
		ProcessBuilder pb1 = new ProcessBuilder();
		pb1.command("echo", "\nEsta es la ultima ejecucion de mi ejercicio");
		pb1.redirectError(ProcessBuilder.Redirect.to(errorFile));
		pb1.redirectOutput(ProcessBuilder.Redirect.appendTo(nuevoFile));
		
		try {
			Process p2 = pb1.start();
			int j = p2.waitFor();
			System.out.println(j);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void addToFile(File f, String txt) throws IOException {
		try(FileWriter fr = new FileWriter(f, true); BufferedWriter writer = new BufferedWriter(fr)) {
			writer.write(txt);
		}
	}
}
