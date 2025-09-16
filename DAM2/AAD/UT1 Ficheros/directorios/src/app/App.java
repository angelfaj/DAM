package app;

import java.io.File;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		// Programa a modo de script para crear una estructura de directorios determinada
		
		String path = "";
		

	}

	public static void elHacedor(String fileName) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("archivo creado");
		}else System.out.println("el archivo ya existe");
	}
	
	public static File[] elEnumerador(String path) {
		File raiz = new File(path);
		if (raiz.isFile()) {
			System.out.println("[ERROR]-la raiz es un archivo");
			return null;
		}else {
			File contenidoRaiz[] = raiz.listFiles();
			
			System.out.println("Contenido de " + raiz.getAbsolutePath() + ":");
			for(File f:contenidoRaiz) {
				System.out.println("- " + f.getName());
			}
			return contenidoRaiz;
		}
	}
	
	public static void elCombinador() {
		
	}
}
