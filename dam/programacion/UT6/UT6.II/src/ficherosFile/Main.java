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
		-
		-
		-
		-
		Si es un archivo, mostrará por pantalla el nombre del archivo.
		Si es un directorio, mostrará por pantalla la lista de directorios y archivos que
		contiene (sus nombres). Deberá mostrar primero los directorios y luego los
		archivos.
		En cualquier caso, añade delante del nombre la etiqueta [*] o [A] para indicar si
		es un directorio o un archivo respectivamente.
		Si el path no existe lanzará un FileNotFoundException.
		
		System.out.println("Introduce una ruta: ");
		File f = new File(entrada.nextLine());
		
		try {
			muestraInfoRuta(f);
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
		
		File docs = new File("Documentos");
		File destination = new File("DOCS");
		File aux;
		
		docs.renameTo(destination);
		docs = new File(destination.getName());	//Tras renombrar un objeto file, este sigue apuntando al nombre antiguo y por tanto debemos sobreescribirlo manualmente
		
		String archivos[] = docs.list();
		
		for (int i = 0; i < archivos.length; i++) { //Vector con el contenido de docs		
			String nombre = "";
			if (archivos[i].equalsIgnoreCase("Fotografias")) {
				nombre = "FOTOS";
			}
			if (archivos[i].equalsIgnoreCase("Libros")) {
				nombre = "LECTURAS";
			}
			destination = new File(docs, nombre);	//Volcamos cada directorio en el objeto destination
			aux = new File(docs, archivos[i]);		//Utilizamos aux para cambiar el nombre al directorio
			aux.renameTo(destination);
			
			for (String s:destination.list()) {
				System.out.println(s);
//				StringTokenizer tokenizer = new StringTokenizer(s, ".");
//				System.out.println(tokenizer.nextToken());
			}
			
//			String auxVector[] = destination.list();	//Vector con el contenido de cada directorio dentro de DOCS/
//			for (int j = 0; j < auxVector.length; j++) {
//				File aux2 = new File(auxVector[j]);
//				StringTokenizer tokenizer = new StringTokenizer(aux2.getName(), ".");
//				File dest2 = new File(tokenizer.nextToken()); //Probar a eter docs, tokenizer
//				
//				aux2.renameTo(dest2);
//				System.out.println(aux2.getName());
//				System.out.println(dest2.getName());
//			}
			
		}
		
		
		//Meter todo en metodos y hacer que funcione :)
		
		
		
		/*
		Ejercicio 5
		Implementa un programa que cree, dentro de ‘Documentos’, dos nuevas carpetas: ‘Mis
		Cosas’ y ‘Alfabeto’. Mueve las carpetas ‘Fotografias’ y ‘Libros’ dentro de ‘Mis Cosas’.
		Luego crea dentro de ‘Alfabeto’ una carpeta por cada letra del alfabeto (en mayúsculas):
		‘A’, ‘B’, ‘C’... ‘Z’. Te serán de ayuda los códigos numéricos ASCII:
		https://elcodigoascii.com.ar
		Ejercicio 6
		Implementa un programa con una función boolean borraTodo(File f) que borre f: Si no
		existe lanzará una excepción. Si es un archivo lo borrará. Si es un directorio, borrará
		primero sus archivos y luego el propio directorio (recuerda que para poder borrar un
		directorio debe estar vacío). Devolverá ‘true’ si pudo borrar el ‘File f’ (‘false’ si no fué
		posible).
		Prueba
		la
		función
		borrando
		las
		carpetas:
		‘Documentos/Fotografias’,
		‘Documentos/Libros’ y ‘Documentos’ (es decir, tres llamadas a la función, en ese orden).
		Nota: después de cada operación hay que informar al usuario del éxito o fracaso en la
		operación.
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
