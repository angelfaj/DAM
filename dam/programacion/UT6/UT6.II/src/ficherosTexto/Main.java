package ficherosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		
		String path2 = "txtPruebaEscritura";
		File fichero = new File(path2);
		FileReader reader = null;
		FileWriter writer = null; 
		este tampoco funciona xD 
		try {
			if (fichero.createNewFile()) {
				System.out.println("Fichero de escritura creado");
			}else {
				System.out.println("El fichero ya existe");
			}
			reader = new FileReader(path2);
			writer = new FileWriter(fichero, true);

			writer.write(ReadFile.readContent(reader));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		//Fin main
	}

}
