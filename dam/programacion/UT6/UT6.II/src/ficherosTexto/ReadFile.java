package ficherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class ReadFile {
	public static FileReader fileReader;
	public static BufferedReader bufferedReader;
	public static int i;
	public static char caracter;
	public static String linea, cadena;
	
	public static void printContentByChar(FileReader fr) throws FileNotFoundException, IOException {
		fileReader = fr;
		while ((i = fileReader.read()) != -1) {
			caracter = (char) i;
			System.out.print(caracter);
		}
	}

	public static void printContentByCharWithOutSpaces(FileReader fr) throws FileNotFoundException, IOException {
		fileReader = fr;
		while ((i = fileReader.read()) != -1) {
			caracter = (char) i;
			if (caracter != ' ') {
				System.out.print(caracter);
			}
		}
	}

	public static void printContentByLine(FileReader fr) throws FileNotFoundException, IOException {
		fileReader = fr;
		bufferedReader = new BufferedReader(fileReader);
		
		while ((linea = bufferedReader.readLine()) != null) {
			System.out.println(linea);
		}
	}
	
	public static String readContent(FileReader fr) throws IOException {
		fileReader = fr;
		bufferedReader = new BufferedReader(fileReader);
		
		while ((linea = bufferedReader.readLine()) != null) {
			cadena += linea; 
		}
		return cadena;
	}
}
