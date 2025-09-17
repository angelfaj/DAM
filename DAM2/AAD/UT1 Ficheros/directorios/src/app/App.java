package app;

import java.io.File;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		// Programa a modo de script para crear una estructura de directorios determinada: Creara un archivo dentro de cada directoro del path dado. /ejemplo/raiz/carpeta1/archivoNuevo, /ejemplo/raiz/carpeta2/archivoNuevo ...
		
		String path = "introduce aqui la ruta raiz";
		String filename = "introduce aqui el nombre del archivo";
		
		System.out.println("Lista de directorios:");
		elEnumerador(path);
		try {
			elOrquestador(path, filename);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void elHacedor(File file) throws IOException {	//Crea el archivo pasado por parametro
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("archivo creado");
		}else System.out.println("el archivo ya existe");
	}
	
	public static File[] elEnumerador(String path) {	//Imprime y devuelve todos los archivos/directorios dentro del path dado
		File raiz = new File(path);
		if (!raiz.exists()) {
			System.out.println("[ERROR]-la ruta ("+path+") no existe");
			return null;
		}else if (raiz.isFile()) {
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
	
	public static void elOrquestador(String pathRaiz, String fileName) throws IOException {	//Combina ambos metodos para crear la estructura deseada
		File[] dirs = elEnumerador(pathRaiz);
		for (File f:dirs) {
			elHacedor(new File(f.getAbsolutePath(), fileName));
		}
	}
}
