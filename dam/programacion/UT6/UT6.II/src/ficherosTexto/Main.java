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
		
		
		
		
		
		
		//Fin main
	}

}
