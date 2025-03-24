package ficherosFile;

import java.io.File;

public abstract class Creater {
	public static boolean createFile(String path, String centinel) {	//Recibe la ruta de archivos o directorios a crear. Centila unicamente con caracter informativo
		File fileToCreate = new File(path);
		
		if (fileToCreate.mkdirs()) {
			System.out.println("Estructura de archivos creada " + centinel);
			return true;
		} else {
			System.out.println("No se ha podido crear la ruta de archivos " + centinel);
			return false;
		}
	}
	
	public static void moveFile(String pathOrigin, String pathDestination) {	//Recide la ruta origen y destino del archivo a mover 
		File origin = new File(pathOrigin);
		File destination = new File(pathDestination);
		if (origin.renameTo(destination)) {
			System.out.println("Elemento movido");
		}else {
			System.out.println("No ha sido posible mover el elemento");
		}	
		
	}
	
	public static void createAbecedaryDirs(String pathOrigin, char start, char end) {
		File parentFile = new File(pathOrigin);
		
		for (int i = (int) start; i <= (int) end; i++) {			//Casteamos para equiparar valores
			char cAux = (char) i;
			String path = parentFile.getPath() + "/" + cAux;	//Estructura a crear
			
			createFile(path, cAux + "");						//Comillas para convertir cAux en string
		}
	}
	
	public static void borraTodo(File f) throws Exception {
		if (!f.exists()) {
			throw new Exception("El fichero no existe");
		}else if (f.isFile()) {
			f.delete();
			System.out.println("Archivo " + f + " eliminado");
		}else if (f.isDirectory()) {
			
		}
		
		
	}
	
	public void deleteContent(File f) {	//Borra todo el contenido del directiorio pasado por parametro
		File childrenNames[] = f.listFiles();
		
		for (File children: childrenNames) {	
			if (children.isFile()) {
				children.delete();
				System.out.println("Archivo " + f + " eliminado");
			}else {
				File grandChildrens[] = children.listFiles();
				for (File gChild: grandChildrens) {
					if (gChild != null) {
						deleteContent(gChild);			//Funcion recursiva que se llama asi misma hasta vaciar cada directorio. Se pisaria la informacion perdiento los primeros desencadenadores??
					}
				}
				children.delete();
			}
		}
	}
	
	

}