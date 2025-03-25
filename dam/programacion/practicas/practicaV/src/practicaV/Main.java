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
		System.out.println("Objetio movido a: " + file.getPath());
	}
	
	public static void deleter(File f) {
		String resul = "";
		if (!f.exists()) {			//Evitamos ejecuciones innecesarias
			System.out.println("El elemento " + f.getName() + " no existe");
		}else if(f.delete()){		//Borramos si es un archivo
			resul = f.getName() + " SI ";
		}else {						//Volcamos su contenido en caso de ser un directorio
			File contenidoPadre[] = f.listFiles();
			for (int i = 0; i < contenidoPadre.length; i++) {
				if (contenidoPadre[i].delete()) {					//Con este for recorremos el primer nivel: padre/*
					resul = contenidoPadre[i].getName() + " SI ";
				}else {
					File contenidoHijo[] = contenidoPadre[i].listFiles();
					for (int j = 0; j < contenidoHijo.length; j++) {//Con este for recorremos el segundo nivel: padre/hijo/*
						if (contenidoHijo[j].delete()) {
							resul = contenidoHijo[j].getName() + " SI ";
						}else {
							resul = contenidoHijo[j].getName() + " NO ";							
							//deleter(contenido[i]); esta linea haria que se borrase el arbol completo de directorios
						}
						System.out.println("El elemento " + resul + "se ha borrado");
					}
					contenidoPadre[i].delete();	//Tras vaciar su contenido borramos la subcarpeta
				}
				System.out.println("El elemento " + resul + "se ha borrado");
			}
			f.delete();						//Tras vaciar su contenido borramos la carpeta
		}
		System.out.println("El elemento " + resul + "se ha borrado");
	}
	
	
	public static void main(String[] args) {
		/*
		ENUNCIADO:
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
		
		//Ejemplo de uso normal
		try {
			createDir(dir1);
			createDir(dir2);
			createFile(f1);
			createFile(f2);
			renamer(f2, "fichero2Renombrado"); 
			fileMover(f1, dir2); 
		} catch (IOException e) {
			e.printStackTrace();
		} 

		deleter(dir1);
		
		//Ejemplo de borrado de directorios ocupados
		//¿Qué problemas pueden surgir al borrar un directorio que contiene otros ficheros dentro?¿Y si tiene otros directorios dentro pero sin ficheros? Prueba y refleja estos casos.
		/*Para borrar un directorio es preciso que este vacio, por ello nuestro metodo deleter, 
		 * se cerciora de ello listanto su contenido en un vector en caso de que el metodo file.delete de error, 
		 * hara esta comprobacion hasta un maximo de tres niveles de profundidad no pudiendo eliminar directorios con archivos en el tercer nivel, solo directorios vacios*/
		
		

	}
}
