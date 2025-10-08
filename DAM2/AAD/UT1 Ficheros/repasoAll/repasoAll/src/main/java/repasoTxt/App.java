package repasoTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
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
		correctamente
		*/
    	File fichero = new File("ficheroRepasoTxt.txt");
    	
    	//Escritura
    	try(FileWriter fr = new FileWriter(fichero); BufferedWriter writer = new BufferedWriter(fr)) {
    		writer.write("Ejercicio 6\r\n"
    				+ "		Crear un programa Java con los siguientes métodos:\r\n"
    				+ "		● contarLíneas: método que devuelve el número de líneas de un fichero\r\n"
    				+ "		pasado como parámetro. Usa Scanner.\r\n"
    				+ "		● contarCaracteres: método que devuelve el número de caracteres de un\r\n"
    				+ "		fichero pasado como parámetro.\r\n"
    				+ "		● contarPalabras: método que devuelve el número de palabras de un\r\n"
    				+ "		fichero pasado como parámetro. Investigar sobre la clase\r\n"
    				+ "		StringTokenizer.\r\n"
    				+ "		● cadenaMax: método que devuelve la palabra más larga encontrada en\r\n"
    				+ "		un fichero pasado como parámetro.\r\n"
    				+ "		● cuentaPalabra: método que devuelve el número de veces que aparece\r\n"
    				+ "		una palabra dentro de un fichero. Ambos se pasan como parámetro al\r\n"
    				+ "		método.\r\n"
    				+ "		Prueba en el método main que los métodos anteriores funcionan\r\n"
    				+ "		correctamente");
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//Lectura con bufferreader
    	try(FileReader fr = new FileReader(fichero); BufferedReader buff = new BufferedReader(fr)) {
    		String linea;
    		System.out.println("Lectura coin buffer");
    		while((linea = buff.readLine()) != null) {
    			System.out.println(linea);
    		}
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//Lectua con chars
    	try(FileReader fr = new FileReader(fichero)){
    		System.out.println("Lectura de chars:");
    		int c;
    		while((c = fr.read()) != -1) {
    			System.out.print((char)c);
    		}
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }
}
