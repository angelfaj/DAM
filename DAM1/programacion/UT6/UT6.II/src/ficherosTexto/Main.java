package ficherosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 1
		Crea un fichero en el bloc de notas con varias cadenas de caracteres. Escribe un
		programa en Java que muestre el contenido de dicho fichero haciendo uso de
		BufferedReader. ¿Qué diferencia hay si se hace con FileReader?*/
		/*
		String path = "txtPruebaLectura";
		FileReader fr = null;
		
		try {
			fr = new FileReader(path);
			
			System.out.println("Imprimimos caracter a caracter");
			ReadFile.printContentByChar(fr);
			fr.close();
			fr = new FileReader(path);

			System.out.println("\n" + "Imprimimos caracter a caracter sin espacios");
			ReadFile.printContentByCharWithOutSpaces(fr);
			fr.close();
			fr = new FileReader(path);

			System.out.println("\n" + "Imprimimos linea por linea");
			ReadFile.printContentByLine(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		*/
		/*Ejercicio 2
		Escribe en un fichero las cadenas de caracteres que escriba un usuario
		acabando con la cadena “fin”. Comprueba posteriormente que el fichero se ha
		creado correctamente mostrando su contenido en pantalla.*/
		/*
		Scanner sc = new Scanner(System.in);
		
		String line = "", text = "", path2 = "txtPruebaEscritura";
		File fichero = new File(path2);
		FileReader reader = null;
		FileWriter writer = null; 

		
		try {	//Dividimos la lectura y escritura en dos bloques try catch pq es necesario cerrar el flujo del writer para que la informacion se guarde en el archivo
			if (fichero.createNewFile()) {
				System.out.println("Fichero de escritura creado");
			}else {
				System.out.println("El fichero ya existe");
			}

			System.out.println("Escribe a continuacion el texto a guardar en el fichero. ('fin' para terminar)");
			do {
				line = sc.nextLine();
				text += line + "\n";
			}while(!line.equalsIgnoreCase("fin"));

			writer = new FileWriter(fichero, true);
			writer.write(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		try {	//Dividimos la lectura y escritura en dos bloques try catch pq es necesario cerrar el flujo del writer para que la informacion se guarde en el archivo
			reader = new FileReader(path2);
			ReadFile.printContentByLine(reader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		sc.close();
		
		*/
		/*Ejercicio 4
		Crea una aplicación donde pidamos el nombre de un fichero por teclado y un
		texto que queramos escribir en el fichero. Después de crear el fichero con la
		información introducida, deberás mostrar por pantalla el texto del fichero pero
		variando entre mayúsculas y minúsculas. Por ejemplo, si escribo: Bienvenidos
		al IES Villaverde deberá devolver bIENVENIDOS AL ies vILLAVERDE.
		Pista... usa FileReader.*/
		
		//Equivalencias ASCII: A - 65, Z - 90, a - 97, z - 122
		/*
		Scanner entrada = new Scanner(System.in);
		FileWriter writer = null;
		FileReader reader = null;

		String text = "", line;
		
		System.out.println("Introduce el nombre de un fichero: ");
		File fichero = new File(entrada.nextLine());
		
		
		try {	//Dividimos la lectura y escritura en dos bloques try catch pq es necesario cerrar el flujo del writer para que la informacion se guarde en el archivo
			if (fichero.createNewFile()) {
				System.out.println("Fichero creado");
			}else {
				System.out.println("El fichero ya existe");
			}

			System.out.println("Escribe a continuacion el texto a guardar en el fichero. ('fin' para terminar)");
			do {
				line = entrada.nextLine();
				text += line + "\n";
			}while(!line.equalsIgnoreCase("fin"));

			writer = new FileWriter(fichero, true);
			writer.write(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		entrada.close();
		
		try {	//Dividimos la lectura y escritura en dos bloques try catch pq es necesario cerrar el flujo del writer para que la informacion se guarde en el archivo
			reader = new FileReader(fichero);
			ReadFile.printContentByCharConvertingSize(reader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		*/
		
		/*Ejercicio 5
		Crea una aplicación que pida el nombre de dos ficheros de texto (se deberá
		comprobar que existen). Debes copiar el contenido de los dos ficheros en uno,
		este tendrá el nombre de los dos ficheros separados por un guion bajo.
		Para unir los ficheros en uno, crea un método donde le pases como parámetro
		los dos ficheros. En este método, aparte de copiar, debe comprobar si existe el
		fichero de destino, en cuyo caso lo eliminará y se volverá a crear. Por ejemplo,
		si tengo un fichero A.txt con “ABC” como contenido y un fichero B.txt con
		“DEF”, el resultado será un fichero llamado A_B.txt con el contenido “ABC
		DEF”.*/
		/*
		File file1, file2, fileComb;
		FileReader reader = null;
		FileWriter writer = null;
		String textToSave = "";		//Alamacenara el texto de ambos archivos
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce la ruta del primer fichero");
		file1 = new File(entrada.nextLine());
		if (!file1.exists()) {
			System.out.println("El fichero no existe, creandolo...");
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Introduce la ruta del segundo fichero");
		file2 = new File(entrada.nextLine());
		if (!file2.exists()) {
			System.out.println("El fichero no existe, creandolo...");
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			reader = new FileReader(file1);
			textToSave = ReadFile.readContent(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (Exception e2) {
				System.out.println("Ha ocurrido un error al cerrar el archivo");
			}
		}
		
		try {
			reader = new FileReader(file2);
			textToSave += "\n" + ReadFile.readContent(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (Exception e2) {
				System.out.println("Ha ocurrido un error al cerrar el archivo");
			}
		}
		try {
			fileComb = ReadFile.fileMerge(file1, file2);	//Almacenamos el objeto devuelto por el metodo
			writer = new FileWriter(fileComb);	
			writer.write(textToSave);
			System.out.println("Fichero " + fileComb.getName() + " creado, con el contenido de " + file1.getName() + " " + file2.getName());
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (Exception e2) {
				System.out.println("Ha ocurrido un error al cerrar el archivo");
			}
		}
		*/
		
		
		/*Ejercicio 6
		Crear un programa Java con los siguientes métodos:
		● contarLíneas: método que devuelve el número de líneas de un fichero
		pasado como parámetro. Usa Scanner.
		● contarCaracteres: método que devuelve el número de caracteres de un
		fichero pasado como parámetro.
		● contarPalabras: método que devuelve el número de palabras de un
		fichero pasado como parámetro. Investigar sobre la clase
		StringTokenizer.
		● cadenaMax: método que devuelve la palabra más larga encontrada en
		un fichero pasado como parámetro.
		● cuentaPalabra: método que devuelve el número de veces que aparece
		una palabra dentro de un fichero. Ambos se pasan como parámetro al
		método.
		Prueba en el método main que los métodos anteriores funcionan
		correctamente.*/
		/*
		File fichero = new File("fichero1");
		
		System.out.println("Numero de lineas en " + fichero.getName() + ": " + Counter.contarLineas(fichero));
		System.out.println("Numero de caracteres en " + fichero.getName() + ": " + Counter.contarCaracteres(fichero));
		System.out.println("Numero de palabras en " + fichero.getName() + ": " + Counter.contarPalabras(fichero));
		System.out.println("Cadena mas larga en " + fichero.getName() + ": " + Counter.cadenaMax(fichero));
		System.out.println("Numero veces que aparece 'java' en " + fichero.getName() + ": " + Counter.cuentaPalabra(fichero, "java"));
		*/
		
		
		
		//Fin main
	}
}
