package practicaV;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void createDir(File f) throws IOException {	
		if (!f.exists()) {
			f.mkdirs();
			System.out.println("Directorio/s creado: " + f.getPath());
		}else {
			System.out.println("El directorio ya existe: " + f.getPath());
		}
	}
	
	public static void createFile(File f) throws IOException {	
		if (!f.exists()) {
			f.createNewFile();
			System.out.println("Fichero creado: " + f.getPath());
		}else {
			System.out.println("El fichero ya existe: " + f.getPath());
		}
	}
	
	public static void renamer(File f, String newName) throws IOException {	
		if(!f.exists()) {		//Si no existe lo creamos como directorio
			createDir(f);
		}
		File aux = new File(f.getParent() + "/" + newName);	//Aux contendra la nueva ruta tras renombrarlo
		f.renameTo(aux);
		f = new File(aux.getPath());						//Actualizamos f para que apunte a la nueva ruta
	}
	
	public static void fileMover(File file, File dirDestiny) throws IOException {
		if (!dirDestiny.exists()) {
			createDir(dirDestiny);
		}
		File aux = new File(dirDestiny, file.getName()); //Aux contendra la nueva ruta tras moverlo
		file.renameTo(aux);
		file = new File(aux.getPath());				//Actualizamos el valor de file para que apunte a la nueva localizacion
	}
	
	public static void deleter(File f) {
		if (f.exists()) {
			
		}
	}
	
	
	public static void main(String[] args) {
		/*
		Crea y sube a esta tarea una clase java SE17 para probar los métodos de File, al menos los siguientes:
		1- Debes crear y comprobar si existen los ficheros y directorios. Si no existen, debes crearlos.
		2 - Debes renombrar directorios y ficheros que estén en alguna ruta que no sea el directorio raíz. Es decir, la ruta debe contener al menos dos carpetas anidadas.
		3 - Debes mover ficheros de un directorio a otro. Si el directorio destino no existe, debes crearlo.
		4 - Debes borrar ficheros y directorios en el orden adecuado. ¿Qué problemas pueden surgir al borrar un directorio que contiene otros ficheros dentro?¿Y si tiene otros directorios dentro pero sin ficheros? Prueba y refleja estos casos.
		5 - Realiza un código ordenado con métodos para cada operación que se quiera realizar e incluye comentarios explicando lo que se pretende hacer.
		6 - Tendrás que explicar en clase el código creado, todo lo que hace y hacer demostración. Para ello dispondrás de 5 minutos.
		*/
		
		File dir1, dir2, f1, f2;
		
		dir1 = new File("practivaV");			//Estructura de ejemplo: practicaV[fichero1, subcarpeta[fichero2]]
		dir2 = new File(dir1, "subcarpeta");
		f1 = new File("fichero1");
		f2 = new File(dir2, "fichero2");
		
		
		
		
		
		

	}
}
