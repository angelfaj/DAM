package ficherosFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/* Prueba
		File f = new File("..");
		
		System.out.println(f.getAbsolutePath());
		if (f.exists()) {
			System.out.println("Existe");
		}else System.out.println("No existe");
		*/
		
		
		/*Ejercicio 1
		Solicita un nombre de fichero o directorio al usuario y, si existe, muestra en pantalla:
		Su ruta
		Ruta absoluta
		Tamaño
		Si se puede leer
		Si se puede escribir
		Si es fichero
		Si es directorio
		Nota 1: Prueba la salida tanto para un archivo como para un directorio
		Nota 2: Si el fichero o directorio no existe, informa al usuario.
		
		
		System.out.println("Introduce un nombre de fichero: ");
		File f = new File(entrada.nextLine());

		if (f.exists()) {
			System.out.println("Ruta: " + f.getPath());
			System.out.println("Ruta absoluta: " + f.getAbsolutePath());
			System.out.println("Tamaño: " + f.getTotalSpace());
			System.out.println("Se puede leer: " + f.canRead());
			System.out.println("Se puede escribir: " + f.canWrite());
			System.out.println("Es fichero: " + f.isFile());
			System.out.println("Es diretorio: " + f.isDirectory());
		} else System.out.println("El directorio o fichero no existe");
		
		entrada.close();
		
		Ejercicio 2
		Implementa un programa que pida al usuario introducir por teclado una ruta del sistema
		de archivos (por ejemplo, “C:/Windows” o “Documentos”) y muestre información sobre
		dicha ruta (ver función más abajo). El proceso se repetirá una y otra vez hasta que el
		usuario introduzca una ruta vacía (tecla intro). Deberá manejar las posibles
		excepciones.
		Necesitarás crear la función void muestraInfoRuta(File ruta) que dada una ruta de tipo
		File haga lo siguiente:
		- Si es un archivo, mostrará por pantalla el nombre del archivo.
		- Si es un directorio, mostrará por pantalla la lista de directorios y archivos que
		  contiene (sus nombres). Deberá mostrar primero los directorios y luego los
		  archivos.
		- En cualquier caso, añade delante del nombre la etiqueta [*] o [A] para indicar si
		  es un directorio o un archivo respectivamente.
		- Si el path no existe lanzará un FileNotFoundException.
		
		System.out.println("Introduce una ruta: ");
		File f = new File(entrada.nextLine());
		
		try {
			muestraInfoRuta(f);	//Metodo implementado al final de esta clase
		} catch (FileNotFoundException file) {
			System.out.println("La ruta no existe");
		}
		
		
		Ejercicio 4
		Implementa un programa que haga lo siguiente:
		Cambiar el nombre de la carpeta ‘Documentos’ a ‘DOCS’, el de la carpeta
		‘Fotografias’ a ‘FOTOS’ y el de la carpeta ‘Libros’ a ‘LECTURAS’
		Cambiar el nombre de todos los archivos de las carpetas FOTOS y LECTURAS
		quitándole la extensión. Por ejemplo, ‘astronauta.jpg’ pasará a llamarse
		‘astronauta’.
		*/
		
		
//		File docs = new File("Documentos");	//REcuerda verificar que sea el nombre correcto
//		if (docs.exists()) {
//			System.out.println("YES");
//		}
//		String names[] = {"DOCS", "FOTOS", "LECTURAS"}; //Nombres para renombrar en orden
//		
//		Renamer.renameAll(docs, names);
//		//Al ejecutarlo 2 veces seguidas arroja error de vector vacio pero al ejecutarlo de nuevo se corrige??
//		

		/*
		Ejercicio 5
		Implementa un programa que cree, dentro de ‘Documentos’, dos nuevas carpetas: ‘Mis
		Cosas’ y ‘Alfabeto’. Mueve las carpetas ‘Fotografias’ y ‘Libros’ dentro de ‘Mis Cosas’.
		Luego crea dentro de ‘Alfabeto’ una carpeta por cada letra del alfabeto (en mayúsculas):
		‘A’, ‘B’, ‘C’... ‘Z’. Te serán de ayuda los códigos numéricos ASCII:
		https://elcodigoascii.com.ar
		*/
		String destination = "DOCS/misCosas";
		String origin = "DOCS/FOTOS";
		
		String pathToCreate = "DOCS/misCosas";
		Creater.createFile(pathToCreate, pathToCreate);
		destination = "DOCS/misCosas/FOTOS";
		Creater.moveFile(origin, destination);
		
		origin = "DOCS/LECTURAS";
		pathToCreate = "DOCS/alfabeto";
		Creater.createFile(pathToCreate, pathToCreate);
		destination = "DOCS/misCosas/LECCTURAS";
		Creater.moveFile(origin, destination);
		Creater.createAbecedaryDirs(pathToCreate, 'A', 'Z');
		
		
		
		/*
		Ejercicio 6
		Implementa un programa con una función boolean borraTodo(File f) que borre f: Si no
		existe lanzará una excepción. Si es un archivo lo borrará. Si es un directorio, borrará
		primero sus archivos y luego el propio directorio (recuerda que para poder borrar un
		directorio debe estar vacío). Devolverá ‘true’ si pudo borrar el ‘File f’ (‘false’ si no fué
		posible). Prueba la función borrando las carpetas:
		‘Documentos/Fotografias’, ‘Documentos/Libros’ y ‘Documentos’ (es decir, tres llamadas a la función, en ese orden).
		Nota: después de cada operación hay que informar al usuario del éxito o fracaso en la operación.
		*/
		
		
		
		
		
		//FIN MAIN
	}

	public static void muestraInfoRuta(File ruta) throws FileNotFoundException {
		if (ruta.isFile()) {
			System.out.println(ruta.getName());
		}else if (ruta.isDirectory()) {
			File[] dir = ruta.listFiles();
			String ficheros = "";
			String directorios = "";
			
			for (File d: dir) {
				//File aux =new File(ruta, d);		Si no le indicamos la ruta de trabajo no encontrará ningun archivo puesto que en el directorio de trabajo por defecto no existirá ninguno de los archivos
				
				if (d.isDirectory()) {
					directorios = "*-" + d.getName() + "\n";
				}else if (d.isFile()) {
					ficheros +="A-" + d.getName() + "\n";
				}
			}
			System.out.println(directorios + ficheros);
		}else if (!ruta.exists()) {
			throw new FileNotFoundException();
		}
		
	}
}
