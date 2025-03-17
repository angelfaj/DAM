package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
		Si el path no existe lanzará un FileNotFoundException.*/
		
		System.out.println("Introduce una ruta: ");
		File f = new File(entrada.nextLine());
		
		try {
			muestraInfoRuta(f);
		} catch (FileNotFoundException file) {
			System.out.println("La ruta no existe");
		}
		
		
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
